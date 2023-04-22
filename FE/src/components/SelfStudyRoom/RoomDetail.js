import React from "react";
import { useNavigate } from "react-router-dom";

import styles from "./RoomDetail.module.css";

const x = [
  {
    id: 1,
    valid: "t",
  },
  {
    id: 2,
    valid: "t",
  },
  {
    id: 3,
    valid: "t",
  },
  {
    id: 4,
    valid: "t",
  },
  {
    id: 5,
    valid: "f",
  },
  {
    id: 6,
    valid: "t",
  },

  {
    id: 7,
    valid: "f",
  },
  {
    id: 8,
    valid: "t",
  },

  {
    id: 9,
    valid: "t",
  },
  {
    id: 10,
    valid: "t",
  },
  {
    id: 11,
    valid: "t",
  },
  {
    id: 12,
    valid: "t",
  },
  {
    id: 13,
    valid: "t",
  },
  {
    id: 14,
    valid: "t",
  },
  {
    id: 15,
    valid: "t",
  },
  {
    id: 16,
    valid: "t",
  },
];

const RoomDetail = () => {
  const navigate = useNavigate();

  const back = () => {
    // console.log("뒤로 가기 버튼입니다.");
    navigate("/reservation/list");
  };

  return (
    <div className={styles.RoomDetail}>
      <div className={styles.RoomLocation}>
        <span className={styles.LocationLabel}>대전 캠퍼스 3층</span>
        <div className={styles.RoomSeperator}></div>
      </div>

      <div className={styles.mainHeader}>
        <div>
          <img src="/assets/images/exitDiv.png" onClick={back} />
        </div>
        <div>
          <div className={styles.SeatStatusTitle}>남은 좌석 수</div>
          <div className={styles.SeatStatus}>15 / 30</div>
        </div>
      </div>

      <div className={styles.SeatList}>
        {x.map((key, index) => {
          if (index % 6 == 3) {
            return (
              <>
                <div></div>
                <div className={key.valid == "t" ? styles.seatNode : styles.seatNodeUsing}>
                  {key.id}
                </div>
              </>
            );
          } else {
            return (
              <div className={key.valid == "t" ? styles.seatNode : styles.seatNodeUsing}>
                {key.id}
              </div>
            );
          }
        })}
      </div>
    </div>
  );
};

export default RoomDetail;
