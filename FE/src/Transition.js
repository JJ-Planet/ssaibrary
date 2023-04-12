import { BrowserRouter as Router, Routes, Route, useLocation } from "react-router-dom";
import Main from "./pages/MainPage/Main";



import LandingPage from "./pages/LandingPage/LandingPage";
import Account from "./pages/AccountPage/AccountPage";
import AccountReservation from "./pages/AccountReservationPage/AccountReservationPage";
import AccountReservationQr from "./pages/AccountReservationPage/AccountReservationPage";
import History from "./pages/HistoryPage/HistoryPage";
import Community from "./pages/CommunityPage/CommunityPage";
import Login from "./pages/LoginPage/LoginPage";
import SignUp from "./pages/SignUpPage/SignUpPage";
import Notice from "./pages/NoticePage/NoticePage";
import Modify from "./pages/AccountModifyPage/AccountModifyPage";
import CommunityWrite from "./pages/CommunityWritePage/CommunityWritePage";
import CommunityDetail from "./pages/CommunityDetailPage/CommunityDetailPage";
import AccountModify from "./pages/AccountModifyPage/AccountModifyPage";
import ReservationList from "./pages/ReservationListPage/ReservationListPage";
import FastCheckPage from "./pages/FastCheckPage/FastCheckPage";
import FAQ from "./pages/FAQPage/FAQPage";
import { TransitionGroup, CSSTransition } from "react-transition-group";
import "./Transition.css";

function Transition() {
  const location = useLocation();
  return (
    <div>
      <TransitionGroup className="transitions-wrapper">
        <CSSTransition key={location.key} classNames={`right`} timeout={300}>
          <Routes location={location}>
            <Route path="/" element={<LandingPage />}></Route>
            <Route path="/main" element={<Main />}></Route>
            <Route path="/fastCheck" element={<FastCheckPage />}></Route>

            <Route path="/account" element={<Account />}></Route>
            <Route path="/account/reservation" element={<AccountReservation />}></Route>
            <Route path="/account/reservation/qr" element={<AccountReservationQr />}></Route>
            <Route path="/account/modify" element={<AccountModify />}></Route>

            <Route path="/reservation/list" element={<ReservationList />}></Route>

            <Route path="/history" element={<History />}></Route>
            <Route path="/login" element={<Login />}></Route>
            <Route path="/signUp" element={<SignUp />}></Route>
            <Route path="/notice" element={<Notice />}></Route>
            <Route path="/modify" element={<Modify />}></Route>

            <Route path="/community" element={<Community />}></Route>
            <Route path="/community/write" element={<CommunityWrite />}></Route>
            <Route path="/community/detail/:key" element={<CommunityDetail />}></Route>
            <Route path="/faq" element={<FAQ />}></Route>
            {/* <Route path="/product/*" element={<Product />}></Route> */}
            {/* 상단에 위치하는 라우트들의 규칙을 모두 확인, 일치하는 라우트가 없는경우 처리 */}
          </Routes>
        </CSSTransition>
      </TransitionGroup>
    </div>
  );
}

export default Transition;
