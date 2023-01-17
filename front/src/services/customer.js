import http from "./axios.js";

const login = async (username, password) => {
    return http.post("user/login", {
        "username": username,
        "password": password
    }).then(res => {
      if (res.status === 200) {
        localStorage.setItem("token", res.data.token)
        console.log(res.data.token)
        http.defaults.headers['Authorization'] =
          'Bearer ' + localStorage.getItem("token")
      }
    })
}

const register = async (username, email, password) => {
    return http.post("user/register", {
        "username": username,
        "email": email,
        "password": password
    }).then(res => {
      if (res.status === 200) {
        return 'Ok'
      }
    })
}

export {login, register};