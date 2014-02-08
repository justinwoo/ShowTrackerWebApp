App = Ember.Application.create();

App.Router.map(function () {
  this.resource('about');  
  this.resource('shows', function () {
    this.resource('editshow', { path: 'edit/:show_id' });  
  });
});

App.ShowsRoute = Ember.Route.extend({
  model: function() {
    return shows;
  }
});

App.EditshowRoute = Ember.Route.extend({
  model: function(params) {
    return shows.findBy('id', params.show_id);
  }
})

App.EditshowController = Ember.ObjectController.extend({
  actions: {
    doneEditing: function () {
      //do something
    }
  }
});

var shows = [{
  id: '1',
  title: '俺のお嫁さんと一心同体',
  episode: '1'
}];
