var AppController = function(app) {
    return {
        home: function () {
            mapView.render();
        },

        profile: function () {
            profileView.render();
        },

        viewprofile: function () {
            viewUserProfile.render();
        },

        login: function () {
            loginView.render();
        },

        logout: function () {
            $.ajax({
                url: 'auth/logout',
                type: 'POST',
                success: function () {
                    $('.navbar  #admin').hide();
                    $('.navbar  #manager').hide();
                    $('.navbar  #cry-out').hide();
                    $('.navbar  #filter').hide();
                    $('.navbar  #stat').hide();
                    $('.navbar  #signUp').show();
                    $('.navbar  #login').show();
                    $('.navbar  #logout').hide();
                }
            });
            mapView.render();
        },

    }
}