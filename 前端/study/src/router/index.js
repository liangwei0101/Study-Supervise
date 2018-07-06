import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import one from '@/components/one.vue'
import two from '@/components/two.vue'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
    path: '/one',
    name: 'one',
    component: one
    },
    {
      path: '/two',
      name: 'two',
      component: two
      },
  ]
})
