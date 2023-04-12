import React, { useState } from "react";
import "./NoticeMain.css";

const DataInfo = [
  {
    id: 1,
    date: "2022.12.20",
    Title: "IOS 14.1 버전 지원 종료 안내",
    desc: "iOS 14는 홈 화면에 배치할 수 있도록 새롭게 디자인된 위젯, 전화 통화 및 Siri의 간결한 디자인으로 iPhone의 핵심 경험을 업데이트합니다. ",
  },
  {
    id: 2,
    date: "2022.12.20",
    Title: "IOS 14.1 버전 지원 종료 안내",
    desc: "2번 description입니다.",
  },
  {
    id: 3,
    date: "2022.12.20",
    Title: "IOS 14.1 버전 지원 종료 안내",
    desc: "3번 description입니다.",
  },
  {
    id: 4,
    date: "2022.12.20",
    Title: "IOS 14.1 버전 지원 종료 안내",
    desc: "4번 description입니다.",
  },
  {
    id: 5,
    date: "2022.12.20",
    Title: "IOS 14.1 버전 지원 종료 안내",
    desc: "5번 description입니다.",
  },
  {
    id: 6,
    date: "2022.12.20",
    Title: "IOS 14.1 버전 지원 종료 안내",
    desc: "6번 description입니다.",
  },
  {
    id: 7,
    date: "2022.12.20",
    Title: "IOS 14.1 버전 지원 종료 안내",
    desc: "7번 description입니다.",
  },
  {
    id: 8,
    date: "2022.12.20",
    Title: "IOS 14.1 버전 지원 종료 안내",
    desc: "8번 description입니다.",
  },
  {
    id: 9,
    date: "2022.12.20",
    Title: "IOS 14.1 버전 지원 종료 안내",
    desc: "9번 description입니다.",
  },
  {
    id: 10,
    date: "2022.12.20",
    Title: "IOS 14.1 버전 지원 종료 안내",
    desc: "10번 description입니다",
  },
  {
    id: 11,
    date: "2022.12.20",
    Title: "IOS 14.1 버전 지원 종료 안내",
    desc: "11번 description입니다",
  },
];

let toggles = [];
for (let i = 0; i < DataInfo.length; i++) toggles[i] = false;

function Main() {
  const rendering = () => {
    const result = [];
    for (let i = 0; i < DataInfo.length; i++) {
      result.push(
        <div className={`Dummy${DataInfo[i].id}`} key={DataInfo[i].id}>
          <div onClick={toggleDesc}>
            <img
              className="ArrowBottomImg"
              src="assets/images/arrowDown.png"
            ></img>
          </div>
          <div className="NoticeLine"></div>
          <span className="NoticeData">{DataInfo[i].date}</span>
          <span className="NoticeSubData">{DataInfo[i].Title}</span>
          <div
            className={`NoticeDesc${DataInfo[i].id}`}
            style={{ display: "none" }}
          >
            {DataInfo[i].desc}
          </div>
        </div>
      );
    }
    return result;
  };
  const toggleDesc = (e) => {
    let tgt = e.target.nextSibling.nextSibling.nextSibling.nextSibling;
    let tgtID = tgt.className.replace("NoticeDesc", "") - 1;
    console.log(toggles[tgtID]);
    if (!toggles[tgtID]) {
      tgt.style.display = "block";
    } else tgt.style.display = "none";
    toggles[tgtID] = !toggles[tgtID];
  };

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
