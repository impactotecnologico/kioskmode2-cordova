function KPlugin () {}

KPlugin.prototype.showApps = function (successCallback, errorCallback) {
  cordova.exec(successCallback, errorCallback, 'KPlugin', 'apps', []);

}

KPlugin.prototype.uninstall = function (successCallback, errorCallback) {
  cordova.exec(successCallback, errorCallback, 'KPlugin', 'onBackPressed', []);
}

KPlugin.install = function() {
  if (!window.plugins) {
    window.plugins = {};
  }
  window.plugins.KPlugin = new KPlugin();
  return window.plugins.KPlugin;
};
cordova.addConstructor(KPlugin.install);