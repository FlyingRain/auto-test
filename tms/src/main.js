import {createApp} from 'vue'
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
    baseURL: 'http://111.231.64.229:8081/autotest',
    timeout: 10000,
});
app.config.globalProperties.$axios = axiosInstance;

app.config.globalProperties.$myGlobal = {

    onlyNumber(value) {
        console.log(value)
        const regex = /^(\d+)?(\.\d*)?$/;
        return regex.test(value)
    },
    isDirectCity(cityName) {
        var directCities = ['北京市', '天津市', '重庆市', '上海市']
        for (let c of directCities) {
            if (c.includes(cityName)) {
                return true
            }
        }
        return false
    }

}


app.use(ElementPlus)
app.mount('#app')
