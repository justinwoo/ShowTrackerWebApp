App.Router.map(function () {
  this.resource('about');  
  this.resource('shows', function() {
    this.resource('editshow', { path: 'shows/edit/:show_id' });
  });
});

App.ShowsRoute = Ember.Route.extend({
  
  model: function() {
    // return shows;
    return this.store.findAll('show');
  }

});

App.EditshowRoute = Ember.Route.extend({
  model: function(params) {
    return this.store.find('show', params.show_id);
  }
});

var shows = [{
  id: '1',
  title: '俺のお嫁さんと一心同体',
  episode: '1'
}];
