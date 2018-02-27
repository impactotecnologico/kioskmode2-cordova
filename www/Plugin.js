/*
var exec = require('cordova/exec');

function plugin() {

}

plugin.prototype.KActivity = function(layout,jsonURL) {
    console.log(layout);
    console.log(jsonURL);
    exec(function(res){}, function(err){}, "Plugin", layout, [jsonURL]);
}

module.exports = new plugin();
*/

function KioskPlugin() {}

// The function that passes work along to native shells
// Message is a string, duration may be 'long' or 'short'

/*
KioskPlugin.prototype.show = function(message, duration, successCallback, errorCallback) {
  var options = {};
  options.message = message;
  options.duration = duration;
  cordova.exec(successCallback, errorCallback, 'Plugin', null, [options]);
}

// Installation constructor that binds KioskPlugin to window
KioskPlugin.install = function() {
  if (!window.plugins) {
    window.plugins = {};
  }
  window.plugins.kioskPlugin = new KioskPlugin();
  return window.plugins.kioskPlugin;
};
cordova.addConstructor(KioskPlugin.install);

*/


var argscheck = require('cordova/argscheck');
var channel = require('cordova/channel');
var utils = require('cordova/utils');
var exec = require('cordova/exec');
var cordova = require('cordova');

function KPlugin () {
  
    var me = this;

    channel.onCordovaReady.subscribe(function () {
        me.getInfo(function (info) {
            console.log("----------- subscribe ----------!!!!!");
        }, function (e) {
            utils.alert('[ERROR] Error initializing Cordova: ' + e);
        });
    });
}

/**
 * Get device info
 *
 * @param {Function} successCallback The function to call when the heading data is available
 * @param {Function} errorCallback The function to call when there is an error getting the heading data. (OPTIONAL)
 */
KPlugin.prototype.getInfo = function (successCallback, errorCallback) {
    argscheck.checkArgs('fF', 'KPlugin.getInfo', arguments);
    exec(successCallback, errorCallback, 'KPlugin', 'getKPluginInfo', []);
};

module.exports = new KPlugin();
