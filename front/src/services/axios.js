import axios from 'axios'

const base_uri = process.env.REACT_APP_CUSTOMER_API;
const http = axios.create({
    baseURL: base_uri
})

http.interceptors.request.use(
    config => {
        config.headers['Authorization'] = `Bearer ${localStorage.getItem('token')}`
        // config.headers['content-type'] = 'application/json'
        return config
    },
    error => {
        const status = error?.request?.status || 0
        const resBaseURL = error?.request?.config?.baseURL
        if (resBaseURL === base_uri && status === 401) {
           if (localStorage.getItem('token')) {
              localStorage.clear()
              window.location.assign('/')
              return Promise.reject(error)
           } else {
              return Promise.reject(error)
           }
        }
        return Promise.reject(error)
    }
)

export default http
