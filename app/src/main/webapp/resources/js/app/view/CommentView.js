var CommentViev = Backbone.View
		.extend({
			initilize : function() {

			},
			tagName : 'div',
			className : 'comment',
			template : _
					.template('<label class="comments_user_name"> <%= userName %> </label><br>'+
							' <label	class="comment_name"> <%= comment %> </label><hr width="100%" size="2">'),

			render : function() {
				// console.log('Render fnction worcking');
				this.$el.html(this.template(this.model.toJSON()));

			}
		});