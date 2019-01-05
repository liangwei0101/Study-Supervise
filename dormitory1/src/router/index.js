import Vue from 'vue'
import Router from 'vue-router'
import main from '@/components/common/main'
import dormitory from '@/components/page/dormitory'
import electric from '@/components/page/electric'
import tableexpand from '@/components/page/table-expand'
import student from '@/components/page/student'
import repair from '@/components/page/repair'
import login from '@/components/login'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/login',
      name: 'login',
      component: login
    },
    {
      path: '/',
      name: 'main',
      component: main
    },
    {
      path: '/dormitory',
      name: 'dormitory',
      component: dormitory
    },
    {
      path: '/electric',
      name: 'electric',
      component: electric
    },
    {
      path: '/tableexpand',
      name: 'tableexpand',
      component: tableexpand
    },
    {
      path: '/student',
      name: 'student',
      component: student
    },
    {
      path: '/repair',
      name: 'repair',
      component: repair
    }
    
  ]
})
