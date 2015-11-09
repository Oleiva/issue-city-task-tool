define([ 'underscore', 'backbone' ], function(_, Backbone) {

	return Backbone.Model.extend({
		urlRoot: 'users/send-notification',
		defaults: {
			email: "",
      		subject: "",
			message: ""
		}
	});
	
});