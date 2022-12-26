import React from "react";
import "./CommunityMain.css";

const DataInfo = [
  {
    id: 1,
    date: "2022.12.20",
    desc: "IOS 14.1 버전 지원 종료 안내",
  },
  {
    id: 2,
    date: "2022.12.20",
    desc: "IOS 14.1 버전 지원 종료 안내",
  },
  {
    id: 3,
    date: "2022.12.20",
    desc: "IOS 14.1 버전 지원 종료 안내",
  },
  {
    id: 4,
    date: "2022.12.20",
    desc: "IOS 14.1 버전 지원 종료 안내",
  },
  {
    date: "2022.12.20",
    desc: "IOS 14.1 버전 지원 종료 안내",
  },
];

const rendering = () => {
  const result = [];
  for (let i = 0; i < DataInfo.length; i++) {
    result.push(
      <div className="Dummy" key={DataInfo[i].id}>
        <div className="Line"></div>
        <span className="Data">{DataInfo[i].date}</span>
        <span className="SubData">{DataInfo[i].desc}</span>
      </div>
    );
  }
  return result;
};

function Main() {
  return (
    <>
      <div className="MainDiv">
        <div className="DataDiv">{rendering()}</div>
      </div>
    </>
  );
}

export default Main;
