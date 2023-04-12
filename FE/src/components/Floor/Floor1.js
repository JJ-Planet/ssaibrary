import React from "react";
import styles from "./Floor.module.css";

let isFull = false;
const current = 30;
const max = 30;
if(current == max){
  isFull = true;
}
function Floor1() {
  return (
    <>
      <div className="RoomLocation">
        <div className="RoomSeperator"></div>
        <span className="LocationLabel">대전 캠퍼스 1층</span>
      </div>

      <div className={styles.Room1Div}>
        <span className={styles.Room1Num}>101</span>
        <div className={styles.BigRoomStatus}>
          {isFull ? "예약 불가" : `${current} / ${max}`}
        </div>
        <div className={isFull ? styles.Full : styles.Empty}></div>
      </div>

      <div className={styles.Room2Div}>
        <span className={styles.Room2Num}>102</span>
        <div className={styles.BigRoomStatus}>
          {isFull ? "예약 불가" : `${current} / ${max}`}
        </div>
        <div className={isFull ? styles.Full : styles.Empty}></div>
      </div>

      <div className={styles.Room3Div}>
        <span className={styles.Room3Num}>103</span>
        <div className={styles.SmallRoomStatus}>
          {isFull ? "예약 불가" : `${current} / ${max}`}
        </div>
        <div className={isFull ? styles.FullSmall : styles.EmptySmall}></div>

      </div>

      <div className={styles.Room4Div}>
        <span className={styles.Room4Num}>104</span>
        <div className={styles.SmallRoomStatus}>
          {isFull ? "예약 불가" : `${current} / ${max}`}
        </div>
        <div className={isFull ? styles.FullSmall : styles.EmptySmall}></div>

      </div>

      <div className={styles.Room5Div}>
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
