import { createRouter, createWebHashHistory } from 'vue-router'
import InboxView from '../views/InboxView.vue'
import SignView from '../views/SignView.vue'
import DraftView from '../views/DraftView.vue'
import TrashView from '../views/TrashView.vue'
import ContactView from '../views/ContactView.vue'
import SentView from '../views/SentView.vue'
import FoldersView from '../views/FoldersView.vue'

const routes = [
  {
    path: '/',
    name: 'sign',
    component: SignView
  },
  {
    path: '/:id/inbox',
    name: 'inbox',
    component: InboxView
  },
  {
    path: '/:id/:folderName/folders',
    name: 'folders',
    component: FoldersView
  },
 
  {
    path: '/:id/draft',
    name: 'draft',
    component: DraftView
  },
  {
    path: '/:id/trash',
    name: 'trash',
    component: TrashView
  },
  {
    path: '/:id/contact',
    name: 'contact',
    component: ContactView
  },
  {
    path: '/:id/sent',
    name: 'sent',
    component: SentView
  },
  
]

const router = createRouter({
  history: createWebHashHistory(process.env.BASE_URL),
  routes: routes,
  linkActiveClass: 'active'
})

export default router
