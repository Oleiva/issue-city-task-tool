define([ 'jquery', 'underscore', 'backbone', 'collection/IssueCollection',
         'view/IssueDetailsView', 'view/CommentListView', 'view/AddIssueView' ],
		function($, _, Backbone, IssueCollection, IssueDetailsView, CommentListView, AddIssueView) {
			var MapView = Backbone.View.extend({
				initialize : function() {
					this.model = new IssueCollection();
				},
				
				events: {
					'click #cry-out': 'addIssueForm'
				},
				
				render : function() {
					map = L.map('map').setView([50.62, 26.25], 13);
					marker = null;
					addIssueView = new AddIssueView( { el: "#form-container" } );
					issueDetailsView = new IssueDetailsView( { el: "#form-container" } );
					commentListView = new CommentListView( { el: ".comments" } );
					var that = this;
					
					L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
					    maxZoom: 18
					}).addTo(map);
					
					map.on('click', onMapClick);
					
					this.model.fetch( { success: function() {
						that.model.each(function(issue) {
							L.marker(issue.get("mapPointer").substr(7, issue.get("mapPointer").length - 1)
									.split(', ')).addTo(map).on('click', onMarkerClick).title = issue.get("id");
						});
					} } );
					
					return this;
				},
				
				addIssueForm: function(e) {
					e.preventDefault();
					addIssueView.render();
				}
			});
			
			function onMarkerClick(e) {
				issueDetailsView.render(this.title);
				//TODO:replace comment list in issue details view
				commentListView.render(this.title);
				Backbone.history.navigate("issue/"+this.title,true)
			}
			
			function onMapClick(e) {
				if(!marker)
					marker = L.marker(e.latlng).addTo(map);
				else
					marker.setLatLng(e.latlng);
			}
			
			return MapView;
		})