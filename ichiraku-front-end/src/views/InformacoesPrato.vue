<template>
  <div class="ConteineInfo">
    <Menu />

    <section class="InfoPrato">
      <div class="volta">
        <router-link to="/opcoes-do-dia"> Voltar </router-link>
      </div>

     
      <div class="OpcaoPratos">
        <div class="Pratos">
          <img :src="'../uploads/produtos/' + prato.id + '.png'" alt="" />

          <div>
            <h2>{{ prato.nome }}</h2>

            <div class="ingredientes">
              <h5>Categoria: {{ prato.categoria }}</h5>
              <h4>Ingredientes: <p>{{ prato.ingredientes }}</p> </h4>

              <h3>R$ {{ prato.preco }}</h3>

            </div>

            <input
              @click="postCesta()"
              value="Adicionar a Cesta"
              class="add_produto"
              type="button"
              id="button_adc"
            />
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import Menu from "@/components/Menu.vue";

export default {
  name: "InformacoesPrato",
  components: {
    Menu,
  },
  // props: ["idProduto"],
  data() {
    return {
      prato: [],
      cesta: {},
      usuario: {},
      idUsuario: "",
      inputNome: "",
      inputPreco: null,
      baseURI: "http://localhost:8080/api/produtos",
      baseURICesta: "http://localhost:8080/api/cesta",
    };
  },
  components: {
    Menu,
  },
  methods: {
    getProdutos() {
      // console.log(this.idProduto);
      this.$http
        .get(this.baseURI + "/" + this.$route.params.idPrato)
        .then((result) => {
          this.prato = result.data;
        });   
    },

    postCesta() {
      this.usuario = JSON.parse(this.$session.get("usuario"));
      this.idUsuario = this.usuario[0].id;

      this.cesta.idPrato = this.prato.id;
      this.cesta.idUsuario = this.idUsuario
      this.cesta.nomePrato = this.prato.nome;
      this.cesta.valorPrato = Number(this.prato.preco);

      this.$http.post(this.baseURICesta, this.cesta).then((result) => {
        console.log("olaaa", this.cesta);
        this.$router.push("/cesta");
      });
    },
  },
  mounted() {
    console.log(this.$route.params.idPrato);
    this.getProdutos();
  },
};
</script>

<style scoped>
.ConteineInfo {
  width: 100%;
  display: flex;
  justify-content: center;
  align-content: center;
}

.InfoPrato {
  width: calc(100% - 290px);
  height: 100vh;
  display: flex;
  flex-direction: column;

  background-color: #ebebeb;
  color: black;
  overflow: auto;
}

.InfoPrato .CardapioPratos {
  width: 80%;
  display: flex;
  justify-content: space-evenly;
  align-items: center;
  height: auto;
  margin: 5px auto;
}

.InfoPrato .CardapioPratos a {
  width: 220px;
  height: 35px;
  position: relative;
  text-decoration: none;
}

.InfoPrato .CardapioPratos .box {
  width: 220px;
  height: 35px;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: white;
  text-align: center;
  position: absolute;
  color: black;
  transition: background-color 0.9s;
  border-radius: 4px;
}

.InfoPrato .CardapioPratos .box p {
  margin: auto;
}

.InfoPrato .CardapioPratos .box:hover {
  background-color: #403939;
  color: white;
}

.InfoPrato .OpcaoPratos {
  width: 80%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-evenly;
  height: auto;
  margin: 10px auto;
  margin-bottom: 30px;
}

.InfoPrato .OpcaoPratos .Pratos {
  width: 100%;
  height: 400px;
  margin: 10px 0;
  display: flex;
  justify-content: space-around;
  border-radius: 8px;
  background-color: white;
}

.InfoPrato .Pratos div {
  width: 50%;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  align-items: center;
}
.InfoPrato .Pratos img {
  width: 260px;
  height: 350px;
  margin: auto;
}

.InfoPrato .Pratos div h2 {
  font-size: 30px;
    margin: 20px  0 0 0;
}
.InfoPrato .Pratos div p {
  text-align: left;
}

.InfoPrato .Pratos div h3 {
  font-size: 30px;
  color: #b40707;
  margin: 20px  0 0 0;
  width: 100%;
  text-align: center;
}

.InfoPrato .Pratos div .ingredientes {
  width: 300px;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}
.InfoPrato .Pratos div .ingredientes h4 {
 margin: 20px  0 0 0;
 
  
}

.InfoPrato .Pratos div .ingredientes h4  p {
   font-size: 18px;
}

.InfoPrato .Pratos .add_produto {
  width: 180px;
  border-radius: 3px;
  background-color: #f42d2d;
  border: 0.7px solid #ec1b1b;
  color: white;
  margin: 8px 0;
  margin-bottom: 25px;
  appearance: button;
  text-align: center;
  text-decoration: none;
  padding: 5px 0;
  transition: background-color 0.5s;
}

.InfoPrato .Pratos .add_produto:hover {
  background-color: #b40707;
  border: 0.7px solid #b40707;
}

.volta {
  margin: 20px auto;
  margin-left: 30px;
}

.volta a {
  width: 135px;
  border-radius: 3px;
  background-color: #f42d2d;
  border: 0.7px solid #ec1b1b;
  color: white;
  margin: 8px 0;
  appearance: button;
  text-align: center;
  text-decoration: none;
  padding: 5px 0;
  transition: background-color 0.5s;
}

.volta a:hover {
  background-color: #b40707;
  border: 0.7px solid #b40707;
}
</style>