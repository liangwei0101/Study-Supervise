// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import iView from 'iview';
import 'iview/dist/styles/iview.css';
import ElementUI from 'element-ui';
import VueResource from 'vue-resource';
Vue.use(ElementUI);
Vue.use(VueResource);
Vue.use(iView);
Vue.config.productionTip = false
Vue.http.options.emulateJSON=true
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
