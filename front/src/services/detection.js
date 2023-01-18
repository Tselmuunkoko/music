import axios from "axios";
import http from "./axios";

const detect = async (base64Audio) => {
    return axios.post("http://localhost:8080/api/v1/music/detect",
    {"audio":base64Audio},
    {
        headers: {
            "Authorization": `Bearer ${localStorage.getItem("token")}`
        }
    })
}

const create = async (name, isGlobal, url) => {
    return axios.post("http://localhost:8080/api/v1/music/create",
    {
        "name": name,
        "isGlobal": isGlobal,
        "url": url
    },
    {
        headers: {
            "Authorization": `Bearer ${localStorage.getItem("token")}`
        }
    })
}

const top = async () => {
    return http.get("music/top") 
}

const getHistory = async () => {
    return http.get("music/history")
}
export {detect, create, top, getHistory}
