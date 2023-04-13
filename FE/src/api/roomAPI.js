import axios from "axios";
/**
 * @author tykimdream
 *
 * @copyright 2023
 */

// 엑시오스 기본 세팅
axios.defaults.baseURL = "http://localhost:8080";
axios.defaults.withCredentials = true;


const getRoomById = async (id) => {
    let url = `/room/${id}`;
    let value;
    await axios
      .post(url)
      .then((response) => {
        console.log(response);
      })
      .catch((error) => {
        console.log(error)
      });
    return value;
  };
  
  export {getRoomById};