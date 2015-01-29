define([ 'underscore', 'backbone', 'model/CommentModel' ], function(_,
		Backbone, CommentModel) {

	var CommentCollection = Backbone.Collection.extend({
		intialize : function(/* add here issue_id*/) {

		},
		url: 'http://localhost:8080/Bawl/all-comments/1', /* add here issue_id*/
		model : CommentModel
	});
	return CommentCollection;

});
