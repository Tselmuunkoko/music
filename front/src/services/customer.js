import axios from "axios";

const base_uri = process.env.REACT_APP_CUSTOMER_API;

axios.interceptors.request.use(
    config => {
      const { origin } = new URL(config.url);
      const allowedOrigins = [base_uri];
      const token = localStorage.getItem('token');
      if (allowedOrigins.includes(origin)) {
        config.headers.authorization = `Bearer ${token}`;
      }
      return config;
    },
    error => {
      return Promise.reject(error);
    }
);

const login = async (username, password) => {
    return axios.post(base_uri+"user/login", {
        "username": username,
        "password": password
    })
    // localStorage.setItem('token', data.token);
}

const register = async (username, password, email) => {
    return axios.post(base_uri+"user/register", {
        "username": username,
        "email": email,
        "password": password
    })
}

export {login, register};