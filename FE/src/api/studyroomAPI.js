import axios from "axios";
/**
 * @author tykimdream
 *
 * @copyright 2023
 */

// 엑시오스 기본 세팅
axios.defaults.baseURL = "http://localhost:8080";
axios.defaults.withCredentials = true;


const getAllStudyRoomInfo = async () => {
    let url = `/studyroom`;
    let value;
    await axios
      .get(url)
      .then((response) => {
        // console.log(response.data);
        value =  response.data;
      })
      .catch((error) => {
        console.log(error)
      });
    return value;
  };
  
  export {getAllStudyRoomInfo};