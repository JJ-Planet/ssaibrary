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
    id: 5,
    date: "2022.12.20",
    desc: "IOS 14.1 버전 지원 종료 안내",
  },
  {
    id: 6,
    date: "2022.12.20",
    desc: "IOS 14.1 버전 지원 종료 안내",
  },
  {
    id: 7,
    date: "2022.12.20",
    desc: "IOS 14.1 버전 지원 종료 안내",
  },
  {
    id: 8,
    date: "2022.12.20",
    desc: "IOS 14.1 버전 지원 종료 안내",
  },
  {
    id: 9,
    date: "2022.12.20",
    desc: "IOS 14.1 버전 지원 종료 안내",
  },
  {
    id: 10,
    date: "2022.12.20",
    desc: "IOS 14.1 버전 지원 종료 안내",
  },
  {
    id: 11,
    date: "2022.12.20",
    desc: "IOS 14.1 버전 지원 종료 안내",
  },
];

const rendering = () => {
  const result = [];
  for (let i = 0; i < DataInfo.length; i++) {
    result.push(
      <div className="Dummy" key={DataInfo[i].id}>
        <div className="ArrowBottomImg"></div>
        <div className="Line"></div>
        <span className="CommunityData">{DataInfo[i].date}</span>
        <span className="CommunitySubData">{DataInfo[i].desc}</span>
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
