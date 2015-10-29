package edu.com.softserveinc.bawl.controllers;

import edu.com.softserveinc.bawl.models.SubscriptionModel;
import edu.com.softserveinc.bawl.services.SubscriptionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/subscriptions")

public class SubscriptionController {

	public static final Logger LOG = Logger.getLogger(StatusController.class);

	@Autowired
	private SubscriptionService service;


	// TODO: Return some nice UI, and correct statuses.
	// TODO: Maybe confirmation

    // addSubscription
	@RequestMapping(method = RequestMethod.POST)
	public  @ResponseBody Map <String, String> addSubscriptionAction(
			    @RequestBody SubscriptionModel sub, Map <String, String> message) {
		try {
			service.create(sub);
			message.put("message", "New subscription was successfully added");
		} catch (Exception e) {
			message.put("message","Some problem occured! New subscription was NOT added");
		}
		return message;
	}

    //  abort Subscription
/*    @RequestMapping(value = "/{id}/delete/{digest}", method = RequestMethod.GET)
    public String cancelSubscriptionFromMailAction(@PathVariable Integer id,@PathVariable String digest) {
        SubscriptionModel sub = service.read(id);
        if (DigestUtils.md5DigestAsHex(sub.toString().getBytes()).equals(digest)) {
            service.delete(sub.getId());
            return "redirect:/";
        }
        return "redirect:/";
    }
*/

    @RequestMapping(value = "/{id}/delete/{digest}", method = RequestMethod.POST)
    public  @ResponseBody Map <String, String> cancelSubscription(
            @RequestBody SubscriptionModel sub, Map <String, String> message) {
        try {
            service.delete(sub.getId());
            message.put("message", "New subscription was successfully added");
        } catch (Exception e) {
            message.put("message","Some problem occured! New subscription was NOT added");
        }
        return message;
    }


}
