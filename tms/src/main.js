import { createApp } from 'vue'
import App from './App.vue'
import './global_style.css'
import ElementPlus from 'element-plus' //全局引入
import 'element-plus/dist/index.css'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import axios from 'axios'

const app = createApp(App)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}

const axiosInstance = axios.create({
    baseURL: 'http://localhost:8081/autotest',
    timeout: 1000,
});
app.config.globalProperties.$axios = axiosInstance;
app.use(ElementPlus)
app.mount('#app')
