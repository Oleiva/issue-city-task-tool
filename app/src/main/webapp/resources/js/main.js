require(['jquery', 'underscore', 'backbone', 'router', 'backbone_route_control',
      'view/MapView', 'view/AddIssueView', 'view/ManagerView', 'view/AdminView', 'view/CategoryManageView',
      'view/LoginView', 'view/IssueFilterView', 'view/StatisticView',
      'view/UserProfileView', 'view/UserRegistrationView', 'view/HistoryView', 'view/ViewUserHistory'],
    function ($, _, Backbone, Router, BackboneRouteControl,
              MapView, AddIssueView, ManagerView, AdminView, CategoryManageView,
              LoginView, IssueFilterView, StatisticView,
              UserProfileView, UserRegistrationView, HistoryView, ViewUserHistory) {

      router = null;
      adminView = null;
      managerView = null;
      categoryManageView = null;
      userRegView = null;
      historyView = null;


      USER_NOT_CONFIRMED = 0;
      USER = 1;
      MANAGER = 2;
      ADMIN = 3;
      SUBSCRIBER = 4;
      DELETED = 5;
      CATEGORY_NEW = "New";
      MAX_IMG_SIZE = 5000000;
      CATEGORY_DELETED = "Deleted"


      jQuery(document).ready(function ($) {
        $.ajaxSetup({
          statusCode: {
            401: function () {
              router.navigate('login', {trigger: true});
            }
          }
        });

        mapView = new MapView({el: "body"});
        issueFilterView = new IssueFilterView({el: "#container"});
        loginView = new LoginView({el: "body"});
        userRegView = new UserRegistrationView({el: "body"});
        issueFilterView = new IssueFilterView({el: "#container"});
        statisticView = new StatisticView({el: 'body'});
        viewUserProfile = new UserProfileView({el: "#container"});
        historyView = new HistoryView();
        validator = Validator();
        viewUserHistory = new ViewUserHistory({el: "#container"});

        router = new Router({
          controllers: {
            login: new AppController(mapView),
            issues: new IssueController(),
            users: new UserController(),
            admins: new AdminController(AdminView, ManagerView, CategoryManageView)
          }
        });

      });
    });
