import { userRoles } from "@/constants/userRoles";

export const sideBarList = [
  {
    label: "Cadastro de Usuário",
    grupo: [
      userRoles.admin,
    ],
    route: "/WlistaUsuario"
  },
  {
    label: "Cadastro de Produtos",
    grupo: [
      userRoles.admin,
      userRoles.stockist
    ],
    route: "/WlistaProduto"
  },
  {
    label: "Histórico de Pedidos",
    grupo: [
      userRoles.admin,
      userRoles.stockist
    ],
    route: "/historicoPedido"
  }
];