define([ 'underscore', 'backbone' ], function(_, Backbone) {

	return Backbone.Model.extend({
			defaults: {
				date: "",
				username: "",
				status:"",
				roleName:"",
				issueName: ""
			}
		});
		
});

	