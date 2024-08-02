import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'main',
            redirect: 'login'
        },
        {
            path: '/login',
            name: 'login',
            component: () => import('@/views/Login')
        },
        {
            path: '/register',
            name: 'register',
            component: () => import('@/views/Register')
        },
        {
            path: '/change-password',
            name: 'changePassword',
            component: () => import('@/views/changePassword')
        },
        {
            path: '/dashboard',
            name: 'dashboard',
            component: () => import('@/views/Dashboard')
        }
    ]
});

export default router;
