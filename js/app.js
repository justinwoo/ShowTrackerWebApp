App = Ember.Application.create();
App.Store = DS.Store.extend({
  adapter: DS.FixtureAdapter
});

App.ShowsController = Ember.ArrayController.extend({
  actions: {
    increment: function (item) {
      // var existingShow = App.Show.find('id', item.id);
      // existingShow.set('id', 500);
    },
    decrement: function (item) {
      episode = item.episode - 1;
    }
  }
});

App.CreateshowController = Ember.ObjectController.extend({
  newTitle: null,
  newEpisode: null,
  actions: {
    // submit: function () {
    //   var newTitle = this.get('newTitle');
    //   var newEpisode = this.get('newEpisode');
    //   var newShow = App.Show.create({
    //     id: 3,
    //     title: newTitle,
    //     episode: newEpisode
    //   });
    //   newShow.save();
    // }
  }
});

App.EditshowController = Ember.ObjectController.extend({
  newTitle: null,
  newEpisode: null,
  actions: {
    doneEditing: function (id) {
      // var newTitle = this.get('newTitle');
      // var newEpisode = this.get('newEpisode');
      // var existingShow = App.Show.find('id', id);
      // if (newTitle != null) {
      //   existingShow.set('title', newTitle);
      // }
      // if (newEpisode != null) {
      //   existingShow.set('episode', newEpisode);
      // }      
    }
  }
});
