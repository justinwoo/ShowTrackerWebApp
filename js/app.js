App = Ember.Application.create();

App.Router.map(function () {
  this.resource('about');  
  this.resource('shows', function () {
    this.resource('editshow', { path: 'edit/:show_id' })
  });
});

App.ShowsRoute = Ember.Route.extend({
  model: function(params) {
    if (params == null) {
      return shows;
    } else {
      return shows.findBy('id', params.show_id);
    }
  }
});


var shows = [{
  id: '1',
  title: '俺のお嫁さんと一心同体',
  episode: '1'
}];
