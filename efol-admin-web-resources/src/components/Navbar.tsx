import React, { useState } from "react";
import { Link } from "react-router-dom";
import * as FaIcons from "react-icons/fa"
import * as AiIcons from "react-icons/ai"
import { SidebarData } from "./SidebarData";
import './Navbar.css';
import { IconContext } from "react-icons";


export default function Navbar() {

    const [sidebar, setSidebar] = useState(true);

    const showSidebar = () => setSidebar(!sidebar);

    function renderSidebarItens(){
        return SidebarData.map((item, index) => {
            return <li key={index} className={item.cName}>
                <Link to={item.path}>
                    {item.icon}
                    <span>{item.title}</span>
                </Link>
            </li>
            });
    }

    return (
        <>
            <IconContext.Provider value={{color: '#fff'}}>
                <div>
                    <div className="navbar">
                        <Link to="#" className="menu-bars">
                            <FaIcons.FaBars onClick={showSidebar} />
                        </Link>
                    </div>
                </div>
                <nav className={sidebar ? 'nav-menu active' : 'nav-menu'}>
                    <ul className="nav-menu-items" onClick={showSidebar}>
                        <li className="navbar-toggle">
                            <Link to="#" className="menu-bars">
                                <AiIcons.AiOutlineClose />
                            </Link>
                        </li>
                        {renderSidebarItens()}
                    </ul>
                </nav>
                <span className="logo">

                </span>
            </IconContext.Provider>
        </>
    )
}