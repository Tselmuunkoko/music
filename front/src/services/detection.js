import axios from "axios";

const detect = async (base64Audio) => {
    return axios.post("http://localhost:8080/api/v1/music/detect",
    {"audio":base64Audio},
    {
        headers: {
            "Authorization": `Bearer ${localStorage.getItem("token")}`
        }
    })
}

const create = async (name, isGlobal) => {
    return axios.post("http://localhost:8080/api/v1/music/create",
    {
        "name": name,
        "isGlobal": isGlobal
    },
    {
        headers: {
            "Authorization": `Bearer ${localStorage.getItem("token")}`
        }
    })
}
export {detect, create}
