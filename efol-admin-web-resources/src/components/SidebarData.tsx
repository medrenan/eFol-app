import React from "react";
import * as FaIcons from "react-icons/fa"
import * as AiIcons from "react-icons/ai"
import * as IoIcons from "react-icons/io5"

export const SidebarData = [
    {
        title: "Home",
        path: "/home",
        icon: <AiIcons.AiFillHome />,
        cName: 'nav-text'
    },
    {
        title: "FOLs",
        path: "/fols",
        icon: <IoIcons.IoDocumentText />,
        cName: 'nav-text'
    },
    {
        title: "Equipments",
        path: "/equipments",
        icon: <AiIcons.AiFillCar />,
        cName: 'nav-text'
    },
    {
        title: "Category",
        path: "/categories",
        icon: <FaIcons.FaWrench />,
        cName: 'nav-text'
    },
    {
        title: "Keywords",
        path: "/keywords",
        icon: <IoIcons.IoKeySharp />,
        cName: 'nav-text'
    }
]