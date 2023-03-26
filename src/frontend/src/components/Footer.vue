<template>
  <footer id="footer">
    <div>
      <img src="../assets/bazinga.png" alt="Bazinga" id="imagem-bazinga">
    </div>

    <p>Bazinga &copy; 2023</p>

    <div class="imagens-footer">
      <a href="https://github.com/LuluFLopes/ProjetoPI-4-Semestre" target="_blank"><img src="../assets/github-icon.png" alt="GitHub"></a>
      <a href="https://trello.com/b/A9QmCOVg/pi-s4" target="_blank"><img src="../assets/trello-icon.png" alt="Trello"></a>
      <a href="https://www.figma.com/file/YQgcS6GFx0RzmvqsfE8ZY1/Bazinga?node-id=0-1&t=Ad2QhSURpxQ41p07-0" target="_blank"><img src="../assets/Figma.png" alt="Figma"></a>
    </div>

  </footer>
</template>

<script>
export default {
  name: "Footer-Vue"
}
</script>

<style scoped>
#footer {
  height: 100px;
  background-color: rgba(217, 217, 217, 1);
  border-top: 2px solid #111;
  color: #222222;
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
}

#imagem-bazinga {
  width: 15%;
  margin: 5px;
  margin-left: 50px;
}

p {
  text-align: center;
  justify-content: center;
  vertical-align: center;
}

.imagens-footer {
  margin: auto;
  margin-right: 0;

}

.imagens-footer img {
  padding: 10px;
}

</style>