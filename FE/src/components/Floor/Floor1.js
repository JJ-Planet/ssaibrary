import React from "react";
import styles from "./Floor.module.css";
import { Link } from "react-router-dom";

let isFull = false;
const current = 29;
const max = 30;
if (current == max) {
  isFull = true;
}
const toDetail = (roomId) => {
  console.log("Detail Page Router", roomId);
};
const nothing = () => {
  console.log("god of chat gpt");
};

function Floor1() {
  return (
    <>
      <div className="RoomLocation">
        <div className="RoomSeperator"></div>
        <span className="LocationLabel">대전 캠퍼스 1층</span>
      </div>
      <Link to="/reservation/list/1">
      <div
        className={styles.Room1Div}
        onClick={isFull ? nothing : () => toDetail(1)}
      >
        <span className={styles.Room1Num}>101</span>
        <div className={styles.BigRoomStatus}>
          {isFull ? "예약 불가" : `${current} / ${max}`}
        </div>
        <div className={isFull ? styles.Full : styles.Empty}></div>
      </div>
      </Link>
      <div
        className={styles.Room2Div}
        onClick={isFull ? nothing : () => toDetail(2)}
      >
        <span className={styles.Room2Num}>102</span>
        <div className={styles.BigRoomStatus}>
          {isFull ? "예약 불가" : `${current} / ${max}`}
        </div>
        <div className={isFull ? styles.Full : styles.Empty}></div>
      </div>

      <div
        className={styles.Room3Div}
        onClick={isFull ? nothing : () => toDetail(3)}
      >
        <span className={styles.Room3Num}>103</span>
        <div className={styles.SmallRoomStatus}>
          {isFull ? "예약 불가" : `${current} / ${max}`}
        </div>
        <div className={isFull ? styles.FullSmall : styles.EmptySmall}></div>
      </div>

      <div
        className={styles.Room4Div}
        onClick={isFull ? nothing : () => toDetail(4)}
      >
        <span className={styles.Room4Num}>104</span>
        <div className={styles.SmallRoomStatus}>
          {isFull ? "예약 불가" : `${current} / ${max}`}
        </div>
        <div className={isFull ? styles.FullSmall : styles.EmptySmall}></div>
      </div>

      <div
        className={styles.Room5Div}
        onClick={isFull ? nothing : () => toDetail(5)}
      >
        <span className={styles.Room5Num}>105</span>
        <div className={styles.SmallRoomStatus}>
          {isFull ? "예약 불가" : `${current} / ${max}`}
        </div>
        <div className={isFull ? styles.FullSmall : styles.EmptySmall}></div>
      </div>
    </>
  );
}

export default Floor1;
