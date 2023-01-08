import React from "react";
import "./FAQMain.css";

const FAQDataInfo = [
  {
    id: 1,
    title: "고객센터 전화번호는 어떻게 되나요?",
    desc: "1번 description 입니다.dddddddd d ddddddd addddd dddd ddddddd dddd ddddddd dddddd dddddddd",
  },
  {
    id: 2,
    title: "SSaibrary는 어떤 서비스 인가요?",
    desc: "2번 description 입니다.",
  },
  {
    id: 3,
    title: "회원 정보 수정은 어떻게 하나요?",
    desc: "3번 description 입니다.",
  },
  {
    id: 4,
    title: "회원 탈퇴는 어떻게 하나요?",
    desc: "4번 description 입니다.",
  },
  {
    id: 5,
    title: "포인트는 무엇인가요?",
    desc: "5번 description 입니다.",
  },
  {
    id: 6,
    title: "포인트를 얻으려면 어떻게 해야 하나요?",
    desc: "6번 description 입니다.",
  },
  {
    id: 7,
    title: "랭킹은 무엇인가요?",
    desc: "7번 description 입니다.",
  },
  {
    id: 8,
    title: "예약은 어떻게 하나요?",
    desc: "8번 description 입니다.",
  },
  {
    id: 9,
    title: "서비스 관련 문의는 어디서 하나요?",
    desc: "9번 description 입니다.",
  },
  {
    id: 10,
    title: "안드로이드 앱 서비스는 언제쯤 하나요?",
    desc: "10번 description 입니다.",
  },
];

let toggles = [];
for (let i = 0; i < FAQDataInfo.length; i++) toggles[i] = false;

const rendering = () => {
  const result = [];
  for (let i = 0; i < FAQDataInfo.length; i++) {
    result.push(
      <div className="Data" key={FAQDataInfo[i].id}>
        <span className="QuestionMark">Q</span>
        <span className="QuestionText">{FAQDataInfo[i].title}</span>
        <div className="DropDownBtn" onClick={FAQtoggleDesc}></div>
        <div className="FAQSeperator2"></div>
        <div className={`FAQDesc${FAQDataInfo[i].id}`} style={{ display: "none" }}>
          {FAQDataInfo[i].desc}
        </div>
      </div>
    );
  }
  return result;
};

const FAQtoggleDesc = (e) => {
  let tgt = e.target.nextSibling.nextSibling;
  let tgtID = tgt.className.replace("FAQDesc", "") - 1;
  if (!toggles[tgtID]) {
    tgt.style.display = "block";
  } else tgt.style.display = "none";
  toggles[tgtID] = !toggles[tgtID];
};

function Main() {
  return (
    <>
      <div className="FAQMain">
        <div className="FAQMenuBar">
          <div className="FAQServiceBtn">
            <span className="FAQServiceBtnText">서비스</span>
          </div>
          <div className="FAQUserBtn">
            <span className="FAQUserBtnText">회원</span>
          </div>
          <div className="FAQPointBtn">
            <span className="FAQPointBtnText">포인트</span>
          </div>
          <div className="FAQRankingBtn">
            <span className="FAQRankingBtnText">랭킹</span>
          </div>
          <div className="FAQReservationBtn">
            <span className="FAQReservationBtnText">예약</span>
          </div>
          <div className="FAQEmphasizingLine"></div>
          <div className="FAQSeperator"></div>
          <div className="FAQDummy">{rendering()}</div>
        </div>
      </div>
    </>
  );
}

export default Main;
