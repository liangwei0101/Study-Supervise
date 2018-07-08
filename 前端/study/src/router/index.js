import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import one from '@/components/one.vue'
import two from '@/components/two.vue'
import three from '@/components/three.vue'
import four from '@/components/four.vue'
import form from '@/components/form.vue'
import table from '@/components/table.vue'
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
    {
      path: '/three',
      name: 'three',
      component: three
    },
    {
      path: '/four',
      name: 'four',
      component: four
    },
    {
      path: '/form',
      name: 'form',
      component: form
    },
    {
      path: '/table',
      name: 'table',
      component: table
    }
  ]
})
