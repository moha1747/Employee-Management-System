import axios from "axios";

const BASE_URL = "http://localhost:8080/user"
class AuthenticationService{
    
    register(userData) {
        return axios.post(`${BASE_URL}/register`, userData)
    }
    login(userData) {
        return axios.post(`${BASE_URL}/login`, userData)
    }
    logout() {
        return axios.post(`${BASE_URL}/logout`);
    }

}
export default new AuthenticationService();