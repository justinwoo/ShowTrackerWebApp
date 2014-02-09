App = Ember.Application.create();
App.Store = DS.Store.extend({
  adapter: DS.FixtureAdapter
});

App.ShowsController = Ember.ArrayController.extend({
  rowNewTitle: null,
  rowNewEpisode: 1,

  actions: {
    increment: function (item) {
      var episode = parseInt(item.get('episode'));
      episode += 1;
      item.set('episode', episode);
      item.save();
    },
    decrement: function (item) {
      var episode = parseInt(item.get('episode'));
      episode -= 1;
      item.set('episode', episode);
      item.save();
    },
    createShow: function () {
      var newTitle = this.get('rowNewTitle');
      var newEpisode = this.get('rowNewEpisode');
      var newShow = this.store.createRecord('show', {
        id: 3,
        title: newTitle,
        episode: newEpisode
      });
    }
  }
});

App.CreateshowController = Ember.ObjectController.extend({
  editingMode: true,
  newTitle: null,
  newEpisode: null,
  actions: {
    submit: function () {
      var newTitle = this.get('newTitle');
      var newEpisode = this.get('newEpisode');
      var newShow = this.store.createRecord('show', {
        id: 3,
        title: newTitle,
        episode: newEpisode
      });
      editingMode = false;
    }
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
