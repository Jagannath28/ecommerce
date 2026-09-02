import Navbar from "./Navbar";
import { useLocation } from "react-router-dom";

const Layout = ({ children }) => {
  const location = useLocation();
  const bg = location.pathname === "/" ? "bg-peach" : "bg-gray-100";

  return (
    <div className="flex flex-col min-h-screen">
      <Navbar />
      <main className={`flex-grow ${bg}`} >{children}</main>
    </div>
  );
};

export default Layout;
