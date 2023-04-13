import React from "react";
import styles from "./FloorListView.module.css";
import { Link } from "react-router-dom";

let isFull = false;
const current = 29;
const max = 30;
if (current == max) {
  isFull = true;
}
const FloorListView = ({ displayFlag, setDisplayFlag }) => {
  const toDetail = (floor) => {
    console.log("Detail Page Router");
    setDisplayFlag(floor);
    console.log(displayFlag)
  };

  console.log(displayFlag)
  return (
    <>
      <div className={styles.list} onClick={() => toDetail(1)}>1층</div>
      <div className={styles.list} onClick={() => toDetail(2)}>2층</div>
      <div className={styles.list} onClick={() => toDetail(3)}>3층</div>
    </>
  );
};

export default FloorListView;
