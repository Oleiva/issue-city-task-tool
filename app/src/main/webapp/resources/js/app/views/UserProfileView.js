define([ 'jquery', 'underscore', 'backbone', 'model/UserModel', 'text!templates/ViewUserProfile.html', 'text!templates/NotificationTemplate.html' ],
		function($, _, Backbone,  UserModel, ViewUserProfileTemplate, NotificationTemplate) {
			var that = null;
			return Backbone.View.extend({
				
				events: {
					'click #admin_log_out'	: 'AppController.logout',
					'change #input-avatar-load' : 'loadAvatar',
					'click #show-select-file' : 'showSelectForm',
					'click #show-edit-profile' : 'editProfile',
					'click #remove-avatar': 'removeAvatar'
				},

				viewUserProfileTemplate : _.template(ViewUserProfileTemplate),
				notificationTemplate : _.template(NotificationTemplate),

				initialize: function() {
					that = this;
					this.model = loginView.currentUser;
				},
				
				render: function() {
					$.ajax({ contentType:'application/json',
						url: 'users/current',
						success: function(data){
							that.model = new UserModel(data);
							that.$el.html(that.viewUserProfileTemplate(that.model.toJSON()));
						}
					});
				},

				editProfile: function() {
					router.navigate('profile', {trigger : true})
				},

				showSelectForm: function(){
					$("#input-avatar-load").click();
				},

				loadAvatar: function() {
					var file = $("#input-avatar-load").prop('files')[0];
					if (file.size < MAX_IMG_SIZE) {
						var fileForm = new FormData();
						fileForm.append("file", file);
						$.ajax({
							dataType: 'json',
							url: "image/avatar",
							data: fileForm,
							type: "POST",
							enctype: 'multipart/form-data',
							processData: false,
							contentType: false,
							success: function (response) {
								that.render();
								if ($('#notificationModal')) $('#notificationModal').remove();
								$("#container").append(that.notificationTemplate({'data': response}));
								$('#notificationModal').modal();
							},
							error: function () {
								if ($('#notificationModal')) $('#notificationModal').remove();
								$("#container").append(that.notificationTemplate({'data': {'message': 'Error uploading!'}}));
								$('#notificationModal').modal();
							}
						});
					} else if (file.size > MAX_IMG_SIZE){
						if ($('#notificationModal')) $('#notificationModal').remove();
						$("#container").append(that.notificationTemplate({'data': {'message': 'File is too large :-( Max image size 5 MB'}}));
						$('#notificationModal').modal();
					}
				},

				removeAvatar: function() {
					$.ajax({
						url: "image/avatar",
						type: "DELETE",
						success: function (response) {
							that.render();
							if ($('#notificationModal')) $('#notificationModal').remove();
							$("#container").append(that.notificationTemplate({'data': response}));
							$('#notificationModal').modal();
						},
						error: function () {
							if ($('#notificationModal')) $('#notificationModal').remove();
							$("#container").append(that.notificationTemplate({'data': {'message': 'Error removing!'}}));
							$('#notificationModal').modal();
						}
					});
				}



			});
})
