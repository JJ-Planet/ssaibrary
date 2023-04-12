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
    id: 3,
    desc: "2022. 12. 11 15:00 - 23:00 자습실 303호 120번",
    time: 480,
  },
  {
    id: 4,
    desc: "2022. 12. 11 15:00 - 23:00 자습실 303호 120번",
    time: 480,
  },
  {
    id: 5,
    desc: "2022. 12. 11 15:00 - 23:00 자습실 303호 120번",
    time: 480,
  },
  {
    id: 6,
    desc: "2022. 12. 11 15:00 - 23:00 자습실 303호 120번",
    time: 480,
  },
  {
    id: 7,
    desc: "2022. 12. 11 15:00 - 23:00 자습실 303호 120번",
    time: 480,
  },
  {
    id: 8,
    desc: "2022. 12. 11 15:00 - 23:00 자습실 303호 120번",
    time: 480,
  },
  {
    id: 9,
    desc: "2022. 12. 11 15:00 - 23:00 자습실 303호 120번",
    time: 480,
  },
  {
    id: 10,
    desc: "2022. 12. 11 15:00 - 23:00 자습실 303호 120번",
    time: 480,
  },
];

const rendering = () => {
  const result = [];
  for (let i = 0; i < DataInfo.length; i++) {
    result.push(
      <div className="HistoryDummy" key={DataInfo[i].id}>
        <span className="HistoryData">{DataInfo[i].desc}</span>
        <span className="HistorySubData">{DataInfo[i].time} min</span>
        <div className="HistorySeperator"></div>
      </div>
    );
  }
  return result;
};

function Main() {
  return (
    <>
      <div className="HistoryMain">
        <div className="HistoryDataDiv">
          <div className="HistorySeperator2"></div>
          {rendering()}
        </div>
      </div>
    </>
  );
}

export default Main;
