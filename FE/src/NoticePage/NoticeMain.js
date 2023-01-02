import React from "react";
import "./NoticeMain.css";

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
        <div className="NoticeLine"></div>
        <span className="NoticeData">{DataInfo[i].date}</span>
        <span className="NoticeSubData">{DataInfo[i].desc}</span>
      </div>
    );
  }
  return result;
};

function Main() {
  return (
    <>
      <div className="MainDiv">
        <div className="DataDiv">
          {rendering()}
          <div className="NoticeLine1"></div>
        </div>
      </div>
    </>
  );
}

export default Main;
