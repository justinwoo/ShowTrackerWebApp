App = Ember.Application.create();
App.Store = DS.Store.extend({
//  adapter: DS.FixtureAdapter
});

App.ShowsController = Ember.ArrayController.extend({
  deleteConfirmation: false,
  deleteShow: null,
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
      var self = this;
      var newTitle = this.get('rowNewTitle');
      var newEpisode = this.get('rowNewEpisode');
      var newShow = this.store.createRecord('show', {
        title: newTitle,
        episode: newEpisode
      });
      this.transitionTo('shows', newShow.save());
    },
    delete: function (item) {
      deleteConfirmation = false;
      item.deleteRecord();
      item.save();
    },
    confirmDelete: function (item) {
      console.log("confirm for " + item);
      deleteConfirmation = true;
      deleteShow = item;
    }
  }
});

App.EditshowController = Ember.ObjectController.extend({
  newTitle: null,
  newEpisode: null,
  actions: {
    doneEditing: function (item) {
      var newTitle = this.get('newTitle');
      var newEpisode = this.get('newEpisode');
      if (newTitle != null) {
        item.set('title', newTitle);
      }
      if (newEpisode != null) {
        item.set('episode', newEpisode);
      }      
      item.save();
    }
  }
});
