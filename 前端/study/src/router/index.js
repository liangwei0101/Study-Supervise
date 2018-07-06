import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import upmenu from '@/components/upmenu.vue'
import leftmenu from '@/components/leftmenu.vue'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
    path: '/upmenu',
    name: 'upmenu',
    component: upmenu
    },
    {
      path: '/leftmenu',
      name: 'leftmenu',
      component: leftmenu
      },
  ]
})
