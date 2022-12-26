import React from "react";
import "./HistoryMain.css";

// let [data, setData] = useState([]);

// 받아온 값을 객체에 넣어줌
const DataInfo = [
  {
    id: 1,
    desc: "2022. 12. 13 17:00 - 21:00 자습실 301호 40번",
    time: 186,
  },
  {
    id: 2,
    desc: "2022. 12. 11 15:00 - 23:00 자습실 303호 120번",
    time: 480,
  },
  {
    id: 2,
    desc: "2022. 12. 11 15:00 - 23:00 자습실 303호 120번",
    time: 480,
  },
  {
    id: 2,
    desc: "2022. 12. 11 15:00 - 23:00 자습실 303호 120번",
    time: 480,
  },
  {
    id: 2,
    desc: "2022. 12. 11 15:00 - 23:00 자습실 303호 120번",
    time: 480,
  },
  {
    id: 2,
    desc: "2022. 12. 11 15:00 - 23:00 자습실 303호 120번",
    time: 480,
  },
  {
    id: 2,
    desc: "2022. 12. 11 15:00 - 23:00 자습실 303호 120번",
    time: 480,
  },
  {
    id: 2,
    desc: "2022. 12. 11 15:00 - 23:00 자습실 303호 120번",
    time: 480,
  },
  {
    id: 2,
    desc: "2022. 12. 11 15:00 - 23:00 자습실 303호 120번",
    time: 480,
  },
  {
    id: 2,
    desc: "2022. 12. 11 15:00 - 23:00 자습실 303호 120번",
    time: 480,
  },
];

const rendering = () => {
  const result = [];
  for (let i = 0; i < DataInfo.length; i++) {
    result.push(
      <div className="Dummy" key={DataInfo[i].id}>
        <div className="Line"></div>
        <span className="Data">{DataInfo[i].desc}</span>
        <span className="SubData">{DataInfo[i].time} min</span>
      </div>
    );
  }
  return result;
};

function Body() {
  return (
    <>
      <div className="Body">
        <div className="DataDiv">{rendering()}</div>
      </div>
    </>
  );
}

export default Body;
