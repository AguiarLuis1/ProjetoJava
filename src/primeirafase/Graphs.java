package primeirafase;

import primeirafase.algs4.*;

import java.util.ArrayList;

import static oracle.jrockit.jfr.events.Bits.intValue;

public class Graphs {
    private EdgeWeightedGraph profissionais;
    private Digraph ligacaoEmpresaProfissional; // pessoas seguem pessoas , pessoas seguem empresas
    private EdgeWeightedDigraph caminhos;

    private Digraph EmpresasSeguidasporProfissisonais;
    private Digraph ProfissionaisEmpresasQueSegue;

    private Digraph encontrosProfissionaisParticipantes;
    private Digraph competenciasProfissionais;

    private RedBlackBST<Integer, Point> pontosDePassagem = new RedBlackBST<>();
    private ST<Double, Peso> weights = new ST<>();


    //gets e sets


    public ST<Double, Peso> getWeights() {
        return weights;
    }

    public void setWeights(ST<Double, Peso> weights) {
        this.weights = weights;
    }

    public Digraph getProfissionaisEmpresasQueSegue() {
        return ProfissionaisEmpresasQueSegue;
    }

    public void setProfissionaisEmpresasQueSegue(Digraph profissionaisEmpresasQueSegue) {
        ProfissionaisEmpresasQueSegue = profissionaisEmpresasQueSegue;
    }

    public RedBlackBST<Integer, Point> getPontosDePassagem() {
        return pontosDePassagem;
    }

    public void setPontosDePassagem(RedBlackBST<Integer, Point> pontosDePassagem) {
        this.pontosDePassagem = pontosDePassagem;
    }

    public Digraph getEmpresasSeguidasporProfissisonais() {
        return EmpresasSeguidasporProfissisonais;
    }

    public void setEmpresasSeguidasporProfissisonais(Digraph empresasSeguidasporProfissisonais) {
        EmpresasSeguidasporProfissisonais = empresasSeguidasporProfissisonais;
    }

    public EdgeWeightedGraph getProfissionais() {
        return profissionais;
    }

    public void setProfissionais(EdgeWeightedGraph profissionais) {
        this.profissionais = profissionais;
    }

    public Digraph getLigacaoEmpresaProfissional() {
        return ligacaoEmpresaProfissional;
    }

    public void setLigacaoEmpresaProfissional(Digraph ligacaoEmpresaProfissional) {
        this.ligacaoEmpresaProfissional = ligacaoEmpresaProfissional;
    }

    public EdgeWeightedDigraph getCaminhos() {
        return caminhos;
    }

    public void setCaminhos(EdgeWeightedDigraph caminhos) {
        this.caminhos = caminhos;
    }

    public Digraph getEncontrosProfissionaisParticipantes() {
        return encontrosProfissionaisParticipantes;
    }

    public void setEncontrosProfissionaisParticipantes(Digraph encontrosProfissionaisParticipantes) {
        this.encontrosProfissionaisParticipantes = encontrosProfissionaisParticipantes;
    }

    public Digraph getCompetenciasProfissionais() {
        return competenciasProfissionais;
    }

    public void setCompetenciasProfissionais(Digraph competenciasProfissionais) {
        this.competenciasProfissionais = competenciasProfissionais;

    }


    public void criarGrafoCaminhos(BD bd) {
        caminhos = new EdgeWeightedDigraph(bd.getStFinal().size());


        Peso peso1 = new Peso(calcularCustoTemporal(50.00, "carro", distanceFromPoints(bd.getStFinal().get(0).getLocalizacao(), bd.getStFinal().get(10).getLocalizacao())), calcularCustoTemporal(50.00, "bicicleta", distanceFromPoints(bd.getStFinal().get(0).getLocalizacao(), bd.getStFinal().get(10).getLocalizacao())), calcularCustoTemporal(50.00, "pe", distanceFromPoints(bd.getStFinal().get(0).getLocalizacao(), bd.getStFinal().get(10).getLocalizacao())), distanceFromPoints(bd.getStFinal().get(0).getLocalizacao(), bd.getStFinal().get(10).getLocalizacao()), 1);
        weights.put(0.00, peso1);
        caminhos.addEdge(new DirectedEdge(0, 10, 0.00));

        Peso peso113 = new Peso(calcularCustoTemporal(50.00, "carro", distanceFromPoints(bd.getStFinal().get(0).getLocalizacao(), bd.getStFinal().get(7).getLocalizacao())), calcularCustoTemporal(50.00, "bicicleta", distanceFromPoints(bd.getStFinal().get(0).getLocalizacao(), bd.getStFinal().get(7).getLocalizacao())), calcularCustoTemporal(50.00, "pe", distanceFromPoints(bd.getStFinal().get(0).getLocalizacao(), bd.getStFinal().get(7).getLocalizacao())), distanceFromPoints(bd.getStFinal().get(0).getLocalizacao(), bd.getStFinal().get(7).getLocalizacao()), 1);
        weights.put(1.00, peso113);
        caminhos.addEdge(new DirectedEdge(0, 7, 1.00));

        Peso peso2 = new Peso(calcularCustoTemporal(120.00, "carro", distanceFromPoints(bd.getStFinal().get(1).getLocalizacao(), bd.getStFinal().get(7).getLocalizacao())), calcularCustoTemporal(120.00, "bicicleta", distanceFromPoints(bd.getStFinal().get(1).getLocalizacao(), bd.getStFinal().get(7).getLocalizacao())), calcularCustoTemporal(120.00, "pe", distanceFromPoints(bd.getStFinal().get(1).getLocalizacao(), bd.getStFinal().get(7).getLocalizacao())), distanceFromPoints(bd.getStFinal().get(1).getLocalizacao(), bd.getStFinal().get(7).getLocalizacao()), 1);
        weights.put(2.00, peso2);
        caminhos.addEdge(new DirectedEdge(1, 7, 2.00));

        Peso peso3 = new Peso(calcularCustoTemporal(100.00, "carro", distanceFromPoints(bd.getStFinal().get(1).getLocalizacao(), bd.getStFinal().get(9).getLocalizacao())), calcularCustoTemporal(100.00, "bicicleta", distanceFromPoints(bd.getStFinal().get(1).getLocalizacao(), bd.getStFinal().get(9).getLocalizacao())), calcularCustoTemporal(100.00, "pe", distanceFromPoints(bd.getStFinal().get(1).getLocalizacao(), bd.getStFinal().get(9).getLocalizacao())), distanceFromPoints(bd.getStFinal().get(1).getLocalizacao(), bd.getStFinal().get(9).getLocalizacao()), 1);
        weights.put(3.00, peso3);
        caminhos.addEdge(new DirectedEdge(1, 9, 3.00));

        Peso peso4 = new Peso(calcularCustoTemporal(30.00, "carro", distanceFromPoints(bd.getStFinal().get(2).getLocalizacao(), bd.getStFinal().get(10).getLocalizacao())), calcularCustoTemporal(30.00, "bicicleta", distanceFromPoints(bd.getStFinal().get(2).getLocalizacao(), bd.getStFinal().get(10).getLocalizacao())), calcularCustoTemporal(30.00, "pe", distanceFromPoints(bd.getStFinal().get(2).getLocalizacao(), bd.getStFinal().get(10).getLocalizacao())), distanceFromPoints(bd.getStFinal().get(2).getLocalizacao(), bd.getStFinal().get(10).getLocalizacao()), 1);
        weights.put(4.00, peso4);
        caminhos.addEdge(new DirectedEdge(2, 10, 4.00));

        Peso peso5 = new Peso(calcularCustoTemporal(30.00, "carro", distanceFromPoints(bd.getStFinal().get(2).getLocalizacao(), bd.getStFinal().get(8).getLocalizacao())), calcularCustoTemporal(30.00, "bicicleta", distanceFromPoints(bd.getStFinal().get(2).getLocalizacao(), bd.getStFinal().get(8).getLocalizacao())), calcularCustoTemporal(30.00, "pe", distanceFromPoints(bd.getStFinal().get(2).getLocalizacao(), bd.getStFinal().get(8).getLocalizacao())), distanceFromPoints(bd.getStFinal().get(2).getLocalizacao(), bd.getStFinal().get(8).getLocalizacao()), 1);
        weights.put(5.00, peso5);
        caminhos.addEdge(new DirectedEdge(2, 8, 5.00));

        Peso peso6 = new Peso(calcularCustoTemporal(70.00, "carro", distanceFromPoints(bd.getStFinal().get(3).getLocalizacao(), bd.getStFinal().get(7).getLocalizacao())), calcularCustoTemporal(70.00, "bicicleta", distanceFromPoints(bd.getStFinal().get(3).getLocalizacao(), bd.getStFinal().get(7).getLocalizacao())), calcularCustoTemporal(70.00, "pe", distanceFromPoints(bd.getStFinal().get(3).getLocalizacao(), bd.getStFinal().get(7).getLocalizacao())), distanceFromPoints(bd.getStFinal().get(3).getLocalizacao(), bd.getStFinal().get(7).getLocalizacao()), 1);
        weights.put(6.00, peso6);
        caminhos.addEdge(new DirectedEdge(3, 7, 6.00));

        Peso peso7 = new Peso(calcularCustoTemporal(100.00, "carro", distanceFromPoints(bd.getStFinal().get(3).getLocalizacao(), bd.getStFinal().get(9).getLocalizacao())), calcularCustoTemporal(100.00, "bicicleta", distanceFromPoints(bd.getStFinal().get(3).getLocalizacao(), bd.getStFinal().get(9).getLocalizacao())), calcularCustoTemporal(100.00, "pe", distanceFromPoints(bd.getStFinal().get(3).getLocalizacao(), bd.getStFinal().get(9).getLocalizacao())), distanceFromPoints(bd.getStFinal().get(3).getLocalizacao(), bd.getStFinal().get(9).getLocalizacao()), 1);
        weights.put(7.00, peso7);
        caminhos.addEdge(new DirectedEdge(3, 9, 7.00));

        Peso peso8 = new Peso(calcularCustoTemporal(100.00, "carro", distanceFromPoints(bd.getStFinal().get(4).getLocalizacao(), bd.getStFinal().get(8).getLocalizacao())), calcularCustoTemporal(100.00, "bicicleta", distanceFromPoints(bd.getStFinal().get(4).getLocalizacao(), bd.getStFinal().get(8).getLocalizacao())), calcularCustoTemporal(100.00, "pe", distanceFromPoints(bd.getStFinal().get(4).getLocalizacao(), bd.getStFinal().get(8).getLocalizacao())), distanceFromPoints(bd.getStFinal().get(4).getLocalizacao(), bd.getStFinal().get(8).getLocalizacao()), 1);
        weights.put(8.00, peso8);
        caminhos.addEdge(new DirectedEdge(4, 8, 8.00));

        Peso peso9 = new Peso(calcularCustoTemporal(80.00, "carro", distanceFromPoints(bd.getStFinal().get(4).getLocalizacao(), bd.getStFinal().get(9).getLocalizacao())), calcularCustoTemporal(80.00, "bicicleta", distanceFromPoints(bd.getStFinal().get(4).getLocalizacao(), bd.getStFinal().get(9).getLocalizacao())), calcularCustoTemporal(80.00, "pe", distanceFromPoints(bd.getStFinal().get(4).getLocalizacao(), bd.getStFinal().get(9).getLocalizacao())), distanceFromPoints(bd.getStFinal().get(4).getLocalizacao(), bd.getStFinal().get(9).getLocalizacao()), 1);
        weights.put(9.00, peso9);
        caminhos.addEdge(new DirectedEdge(4, 9, 9.00));

        Peso pesoA = new Peso(calcularCustoTemporal(50.00, "carro", distanceFromPoints(bd.getStFinal().get(5).getLocalizacao(), bd.getStFinal().get(8).getLocalizacao())), calcularCustoTemporal(50.00, "bicicleta", distanceFromPoints(bd.getStFinal().get(5).getLocalizacao(), bd.getStFinal().get(8).getLocalizacao())), calcularCustoTemporal(50.00, "pe", distanceFromPoints(bd.getStFinal().get(5).getLocalizacao(), bd.getStFinal().get(8).getLocalizacao())), distanceFromPoints(bd.getStFinal().get(5).getLocalizacao(), bd.getStFinal().get(8).getLocalizacao()), 1);
        weights.put(10.00, pesoA);
        caminhos.addEdge(new DirectedEdge(5, 8, 10.00));

        Peso pesoB = new Peso(calcularCustoTemporal(120.00, "carro", distanceFromPoints(bd.getStFinal().get(6).getLocalizacao(), bd.getStFinal().get(10).getLocalizacao())), calcularCustoTemporal(120.00, "bicicleta", distanceFromPoints(bd.getStFinal().get(6).getLocalizacao(), bd.getStFinal().get(10).getLocalizacao())), calcularCustoTemporal(120.00, "pe", distanceFromPoints(bd.getStFinal().get(6).getLocalizacao(), bd.getStFinal().get(10).getLocalizacao())), distanceFromPoints(bd.getStFinal().get(6).getLocalizacao(), bd.getStFinal().get(10).getLocalizacao()), 1);
        weights.put(11.00, pesoB);
        caminhos.addEdge(new DirectedEdge(6, 10, 11.00));

        Peso pesoC = new Peso(calcularCustoTemporal(70.00, "carro", distanceFromPoints(bd.getStFinal().get(7).getLocalizacao(), bd.getStFinal().get(3).getLocalizacao())), calcularCustoTemporal(70.00, "bicicleta", distanceFromPoints(bd.getStFinal().get(7).getLocalizacao(), bd.getStFinal().get(3).getLocalizacao())), calcularCustoTemporal(70.00, "pe", distanceFromPoints(bd.getStFinal().get(7).getLocalizacao(), bd.getStFinal().get(3).getLocalizacao())), distanceFromPoints(bd.getStFinal().get(7).getLocalizacao(), bd.getStFinal().get(3).getLocalizacao()), 1);
        weights.put(12.00, pesoC);
        caminhos.addEdge(new DirectedEdge(7, 3, 12.00));

        Peso pesoD = new Peso(calcularCustoTemporal(50.00, "carro", distanceFromPoints(bd.getStFinal().get(7).getLocalizacao(), bd.getStFinal().get(0).getLocalizacao())), calcularCustoTemporal(50.00, "bicicleta", distanceFromPoints(bd.getStFinal().get(7).getLocalizacao(), bd.getStFinal().get(0).getLocalizacao())), calcularCustoTemporal(50.00, "pe", distanceFromPoints(bd.getStFinal().get(7).getLocalizacao(), bd.getStFinal().get(0).getLocalizacao())), distanceFromPoints(bd.getStFinal().get(7).getLocalizacao(), bd.getStFinal().get(0).getLocalizacao()), 1);
        weights.put(13.00, pesoD);
        caminhos.addEdge(new DirectedEdge(7, 0, 13.00));

        Peso pesoE = new Peso(calcularCustoTemporal(120.00, "carro", distanceFromPoints(bd.getStFinal().get(7).getLocalizacao(), bd.getStFinal().get(1).getLocalizacao())), calcularCustoTemporal(120.00, "bicicleta", distanceFromPoints(bd.getStFinal().get(7).getLocalizacao(), bd.getStFinal().get(1).getLocalizacao())), calcularCustoTemporal(120.00, "pe", distanceFromPoints(bd.getStFinal().get(7).getLocalizacao(), bd.getStFinal().get(1).getLocalizacao())), distanceFromPoints(bd.getStFinal().get(7).getLocalizacao(), bd.getStFinal().get(1).getLocalizacao()), 1);
        weights.put(14.00, pesoE);
        caminhos.addEdge(new DirectedEdge(7, 1, 14.00));

        Peso pesoF = new Peso(calcularCustoTemporal(70.00, "carro", distanceFromPoints(bd.getStFinal().get(8).getLocalizacao(), bd.getStFinal().get(0).getLocalizacao())), calcularCustoTemporal(70.00, "bicicleta", distanceFromPoints(bd.getStFinal().get(8).getLocalizacao(), bd.getStFinal().get(0).getLocalizacao())), calcularCustoTemporal(70.00, "pe", distanceFromPoints(bd.getStFinal().get(8).getLocalizacao(), bd.getStFinal().get(0).getLocalizacao())), distanceFromPoints(bd.getStFinal().get(8).getLocalizacao(), bd.getStFinal().get(0).getLocalizacao()), 1);
        weights.put(15.00, pesoF);
        caminhos.addEdge(new DirectedEdge(8, 0, 15.00));

        Peso pesoG = new Peso(calcularCustoTemporal(30.00, "carro", distanceFromPoints(bd.getStFinal().get(8).getLocalizacao(), bd.getStFinal().get(2).getLocalizacao())), calcularCustoTemporal(30.00, "bicicleta", distanceFromPoints(bd.getStFinal().get(8).getLocalizacao(), bd.getStFinal().get(2).getLocalizacao())), calcularCustoTemporal(30.00, "pe", distanceFromPoints(bd.getStFinal().get(8).getLocalizacao(), bd.getStFinal().get(2).getLocalizacao())), distanceFromPoints(bd.getStFinal().get(8).getLocalizacao(), bd.getStFinal().get(2).getLocalizacao()), 1);
        weights.put(16.00, pesoG);
        caminhos.addEdge(new DirectedEdge(8, 2, 16.00));

        Peso pesoH = new Peso(calcularCustoTemporal(100.00, "carro", distanceFromPoints(bd.getStFinal().get(8).getLocalizacao(), bd.getStFinal().get(4).getLocalizacao())), calcularCustoTemporal(100.00, "bicicleta", distanceFromPoints(bd.getStFinal().get(8).getLocalizacao(), bd.getStFinal().get(4).getLocalizacao())), calcularCustoTemporal(100.00, "pe", distanceFromPoints(bd.getStFinal().get(8).getLocalizacao(), bd.getStFinal().get(4).getLocalizacao())), distanceFromPoints(bd.getStFinal().get(8).getLocalizacao(), bd.getStFinal().get(4).getLocalizacao()), 1);
        weights.put(17.00, pesoH);
        caminhos.addEdge(new DirectedEdge(8, 4, 17.00));

        Peso pesoI = new Peso(calcularCustoTemporal(50.00, "carro", distanceFromPoints(bd.getStFinal().get(8).getLocalizacao(), bd.getStFinal().get(5).getLocalizacao())), calcularCustoTemporal(50.00, "bicicleta", distanceFromPoints(bd.getStFinal().get(8).getLocalizacao(), bd.getStFinal().get(5).getLocalizacao())), calcularCustoTemporal(50.00, "pe", distanceFromPoints(bd.getStFinal().get(8).getLocalizacao(), bd.getStFinal().get(5).getLocalizacao())), distanceFromPoints(bd.getStFinal().get(8).getLocalizacao(), bd.getStFinal().get(5).getLocalizacao()), 1);
        weights.put(18.00, pesoI);
        caminhos.addEdge(new DirectedEdge(8, 5, 18.00));

        Peso pesoJ = new Peso(calcularCustoTemporal(100.00, "carro", distanceFromPoints(bd.getStFinal().get(9).getLocalizacao(), bd.getStFinal().get(3).getLocalizacao())), calcularCustoTemporal(100.00, "bicicleta", distanceFromPoints(bd.getStFinal().get(9).getLocalizacao(), bd.getStFinal().get(3).getLocalizacao())), calcularCustoTemporal(100.00, "pe", distanceFromPoints(bd.getStFinal().get(9).getLocalizacao(), bd.getStFinal().get(3).getLocalizacao())), distanceFromPoints(bd.getStFinal().get(9).getLocalizacao(), bd.getStFinal().get(3).getLocalizacao()), 1);
        weights.put(19.00, pesoJ);
        caminhos.addEdge(new DirectedEdge(9, 3, 19.00));

        Peso pesoK = new Peso(calcularCustoTemporal(120.00, "carro", distanceFromPoints(bd.getStFinal().get(10).getLocalizacao(), bd.getStFinal().get(6).getLocalizacao())), calcularCustoTemporal(120.00, "bicicleta", distanceFromPoints(bd.getStFinal().get(10).getLocalizacao(), bd.getStFinal().get(6).getLocalizacao())), calcularCustoTemporal(120.00, "pe", distanceFromPoints(bd.getStFinal().get(10).getLocalizacao(), bd.getStFinal().get(6).getLocalizacao())), distanceFromPoints(bd.getStFinal().get(10).getLocalizacao(), bd.getStFinal().get(6).getLocalizacao()), 1);
        weights.put(20.00, pesoK);
        caminhos.addEdge(new DirectedEdge(10, 6, 20.00));

        Peso pesoL = new Peso(calcularCustoTemporal(30.00, "carro", distanceFromPoints(bd.getStFinal().get(10).getLocalizacao(), bd.getStFinal().get(2).getLocalizacao())), calcularCustoTemporal(30.00, "bicicleta", distanceFromPoints(bd.getStFinal().get(10).getLocalizacao(), bd.getStFinal().get(2).getLocalizacao())), calcularCustoTemporal(30.00, "pe", distanceFromPoints(bd.getStFinal().get(10).getLocalizacao(), bd.getStFinal().get(2).getLocalizacao())), distanceFromPoints(bd.getStFinal().get(10).getLocalizacao(), bd.getStFinal().get(2).getLocalizacao()), 1);
        weights.put(21.00, pesoL);
        caminhos.addEdge(new DirectedEdge(10, 2, 21.00));

        Peso pesoM = new Peso(calcularCustoTemporal(50.00, "carro", distanceFromPoints(bd.getStFinal().get(10).getLocalizacao(), bd.getStFinal().get(0).getLocalizacao())), calcularCustoTemporal(50.00, "bicicleta", distanceFromPoints(bd.getStFinal().get(10).getLocalizacao(), bd.getStFinal().get(0).getLocalizacao())), calcularCustoTemporal(50.00, "pe", distanceFromPoints(bd.getStFinal().get(10).getLocalizacao(), bd.getStFinal().get(0).getLocalizacao())), distanceFromPoints(bd.getStFinal().get(10).getLocalizacao(), bd.getStFinal().get(0).getLocalizacao()), 1);
        weights.put(22.00, pesoM);
        caminhos.addEdge(new DirectedEdge(10, 0, 22.00));

        System.out.println(caminhos);
        for (double i = 0.00; i < 23.00; i++) {
            System.out.println(i + "-> " + weights.get(i).toString());
        }
    }


    public double calcularCustoTemporal(double velocidademaxima, String veiculo, double distancia) {
        double custo = 0;
        double velocidademedia = 0;

        if (veiculo.equals("carro")) {
            if (velocidademaxima >= 90.00 && velocidademaxima <= 120.00) {
                velocidademedia = 100.00;
            } else if (velocidademaxima >= 50.00 && velocidademaxima < 90.00) {// autro estrada
                velocidademedia = 70.00;
            } else if (velocidademaxima < 50.00) {
                velocidademedia = 30.00;
            }
        }
        if (veiculo.equals("bicicleta")) {
            if (velocidademaxima >= 50.00) {
                velocidademedia = 35.00;
            } else velocidademedia = 15.00;
        }
        if (veiculo.equals("pe")) {
            velocidademedia = 8.00;

        }
        custo = distancia / velocidademedia;
        custo = custo * 60; // passar para minutos
        custo = Math.round(custo * 100.0) / 100.0; // arredondar para duas decimas
        return custo;

    }
/*
    public void criarGrafoCaminhosFromTxt(String path,String dekimeter){
        caminhos = new EdgeWeightedDigraph(bd.getStFinal().size());



    }
    */

    public void criarGrafoCompetenciasProfissionais(BD bd) {
        competenciasProfissionais = new Digraph(bd.getProfissionais().size() + bd.getCompetencias().size());

        for (Integer s : bd.getCompetencias().keys()) {
            for (Integer b : bd.getProfissionais().keys()) {


                if (bd.getCompetencias().get(s).getProfissionaisAtribuidos().get(b) != null) { // verificar se o seguidor em questao, da empresa em questao realmente existe, evitando erro no if seguinte
                    if (bd.getCompetencias().get(s).getProfissionaisAtribuidos().get(b).getIdProfissional() == bd.getProfissionais().get(b).getIdProfissional()) { // para comparar o id do seguidor da empresa com o id do profissional existente
                        competenciasProfissionais.addEdge(bd.getCompetencias().get(s).getIdCompetencia(), bd.getProfissionais().get(b).getIdProfissional());
                    }
                }
            }
        }
        System.out.print(competenciasProfissionais);


    }

    public void criarGrafoencontrosProfissionaisParticipantes(BD bd) {
        encontrosProfissionaisParticipantes = new Digraph(bd.getEmpresas().size() + bd.getProfissionais().size());

        for (Integer s : bd.getEncontros().keys()) {
            for (Integer b : bd.getProfissionais().keys()) {


                if (bd.getEncontros().get(s).getParticipantes().get(b) != null) { // verificar se o seguidor em questao, da empresa em questao realmente existe, evitando erro no if seguinte
                    if (bd.getEncontros().get(s).getParticipantes().get(b).getIdProfissional() == bd.getProfissionais().get(b).getIdProfissional()) { // para comparar o id do seguidor da empresa com o id do profissional existente
                        encontrosProfissionaisParticipantes.addEdge(bd.getEncontros().get(s).getIdEncontro(), bd.getProfissionais().get(b).getIdProfissional());
                    }
                }
            }
        }
        System.out.print(encontrosProfissionaisParticipantes);


    }

    public void criarGrafoEmpresasSeguidasporProfissisonais(BD bd) {
        EmpresasSeguidasporProfissisonais = new Digraph(bd.getEmpresas().size() + bd.getProfissionais().size());

        for (Integer s : bd.getEmpresas().keys()) {
            for (Integer b : bd.getProfissionais().keys()) {


                if (bd.getEmpresas().get(s).getProfissionaisASeguir().get(b) != null) { // verificar se o seguidor em questao, da empresa em questao realmente existe, evitando erro no if seguinte
                    if (bd.getEmpresas().get(s).getProfissionaisASeguir().get(b).getIdProfissional() == bd.getProfissionais().get(b).getIdProfissional()) { // para comparar o id do seguidor da empresa com o id do profissional existente
                        EmpresasSeguidasporProfissisonais.addEdge(bd.getEmpresas().get(s).getIdEmpresa(), bd.getProfissionais().get(b).getIdProfissional());
                    }
                }
            }
        }
        System.out.print(EmpresasSeguidasporProfissisonais);


    }

    public void criarGrafoProfissionaisEmpresasQueSegue(BD bd) {
        ProfissionaisEmpresasQueSegue = new Digraph(bd.getEmpresas().size() + bd.getProfissionais().size());

        for (Integer s : bd.getProfissionais().keys()) {
            for (Integer b : bd.getEmpresas().keys()) {


                if (bd.getProfissionais().get(s).getempresasSeguidaspeloProfissional().get(b) != null) { // verificar se o seguidor em questao, da empresa em questao realmente existe, evitando erro no if seguinte
                    if (bd.getProfissionais().get(s).getempresasSeguidaspeloProfissional().get(b).getIdEmpresa() == bd.getEmpresas().get(b).getIdEmpresa()) { // para comparar o id do seguidor da empresa com o id do profissional existente
                        ProfissionaisEmpresasQueSegue.addEdge(bd.getProfissionais().get(s).getIdProfissional(), bd.getEmpresas().get(b).getIdEmpresa());
                    }
                }
            }
        }
        System.out.print(ProfissionaisEmpresasQueSegue);


    }

    public void criarGrafoProfissionais(BD bd) {
        profissionais = new EdgeWeightedGraph(bd.getProfissionais().size());


        for (Integer s : bd.getProfissionais().keys()) {
            for (Integer b : bd.getProfissionais().keys()) {

                if (b > s) {
                    double compability = formulaPesoProfissionais(bd, bd.getProfissionais().get(s), bd.getProfissionais().get(b)); // compara os dois profissionais retornando a sua compatiblidade

                    if (bd.getProfissionais().get(s).getIdProfissional() != bd.getProfissionais().get(b).getIdProfissional()) { // para nao adicionar duas vezes o mesmo profissional.que terao uma compatiblidade muito garnde visto que esta a comparra se consigo proprio
                        profissionais.addEdge(new Edge(bd.getProfissionais().get(s).getIdProfissional(), bd.getProfissionais().get(b).getIdProfissional(), compability)); // adiciona as edges e o seu peso (compatiblidade)
                    }
                }
            }
        }

        System.out.print(profissionais);

    }


    public void criarGrafoLigacaoEmpresaProfissional(BD bd) {
        ligacaoEmpresaProfissional = new Digraph(bd.getProfissionais().size() + bd.getEmpresas().size());

        for (Integer s : bd.getEmpresas().keys()) {
            for (Integer b : bd.getProfissionais().keys()) {


                if (bd.getEmpresas().get(s).getTrabalhadores().get(b) != null) { // verificar se o trabalhador em questao da empresa em questao realmente existe, evitando erro no if seguinte
                    if (bd.getEmpresas().get(s).getTrabalhadores().get(b).getIdProfissional() == bd.getProfissionais().get(b).getIdProfissional()) { // para comparar o id do trabalhador da empresa com o id do profissional existente
                        ligacaoEmpresaProfissional.addEdge(bd.getEmpresas().get(s).getIdEmpresa(), bd.getProfissionais().get(b).getIdProfissional());
                    }
                }
            }
        }
        System.out.print(ligacaoEmpresaProfissional);
    }


    public double formulaPesoProfissionais(BD bd, Profissional p1, Profissional p2) {
        double compability = 0;
        for (Integer f : p1.getEmpresasASeguir().keys()) {
            for (Integer p : p2.getEmpresasASeguir().keys()) {

                if (p1.getEmpresasASeguir().get(f).getIdEmpresa() == p2.getEmpresasASeguir().get(p).getIdEmpresa()) {
                    compability += 2;
                }
            }
        }

        for (Integer f : p1.getempresasSeguidaspeloProfissional().keys()) {
            for (Integer p : p2.getempresasSeguidaspeloProfissional().keys()) {

                if (p1.getempresasSeguidaspeloProfissional().get(f).getIdEmpresa() == p2.getempresasSeguidaspeloProfissional().get(p).getIdEmpresa()) {
                    compability += 2;
                }
            }
        }

        for (Integer q : p1.getEmpresasAntigas().keys()) {
            for (Integer w : p2.getEmpresasAntigas().keys()) {

                if (p1.getEmpresasAntigas().get(q).getIdEmpresa() == p2.getEmpresasAntigas().get(w).getIdEmpresa()) {
                    compability++;
                }
            }
        }
        ArrayList<String> areasdei1 = p1.getAreasDeInteresse();
        ArrayList<String> areasdei2 = p2.getAreasDeInteresse();
        for (String m : areasdei1) {
            for (String n : areasdei2) {
                if (m.equals(n)) {
                    compability++;
                }


            }
        }
        for (Integer b : p1.getCompetencias().keys()) {
            for (Integer v : p2.getCompetencias().keys()) {

                if (p1.getCompetencias().get(b).getTipo().equals(p2.getCompetencias().get(v).getTipo())) {
                    compability += 3;
                }
            }
        }


        return compability;
    }

    public boolean isConnected(EdgeWeightedGraph G) {
        boolean m = false;
        CC cc = new CC(G);
        for (int i =0; i < G.V(); i++) {
            for (int j = i + 1; j < G.V(); j++) {
                m = cc.connected(i, j);
                if (m = false) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(Graph G) {
        Bipartite b = new Bipartite(G);
        return b.isBipartite();
    }


    private double distanceFromPoints(Point p1, Point p2) {
        double modlex = Math.abs(p1.getX() - p2.getX());
        double modley = Math.abs(p1.getY() - p2.getY());


        return Math.round(Math.sqrt(Math.pow(modley, 2) + Math.pow(modlex, 2)) * 100.0) / 100.0;
    }


    public void listarProfissionaisSeguemThisEmpresa(BD bd, Empresa empresa, Digraph g) {
        int s = empresa.getIdEmpresa();
        DirectedDFS search = new DirectedDFS(g, s);
        System.out.println("Empresa: id:[" + empresa.getIdEmpresa() + "] - Nome: {" + empresa.getNome() + "} - Localização: " + empresa.getLocalizacao().getX() + empresa.getLocalizacao().getY() +
                "\n Profissionais que seguem empresa:");
        for (int v = 0; v < g.V(); v++) {
            if (search.marked(v)) {
                StdOut.println("\tid: " + bd.getProfissionais().get(v).getIdProfissional() + "\tNome: "
                        + bd.getProfissionais().get(v).getPrimeiroNome() + " " + bd.getProfissionais().get(v).getUltimoNome() + "\tLocalização: "
                        + bd.getProfissionais().get(v).getLocalizacao().getX() + bd.getProfissionais().get(v).getLocalizacao().getY() + " ");

            }
        }
        StdOut.println();

    }

    public void listarProfissionaisParticipantesThisEncontro(BD bd, Encontro encontro, Digraph g, Data data) {
        //compara a data instantanea com  a data em que o encontro ocorre ou ocorreu
        if (data.compareTo(encontro.getData()) < 0) { // se o encontro ultrapassar a data atual, significa que ainda nao ocorreu logo esta apenas agendado
            System.out.print("O encontro inserido está agendado, ainda nao ocorreu !");
        } else {

            int s = encontro.getIdEncontro();
            DirectedDFS search = new DirectedDFS(g, s);
            System.out.println("Encontro: id:[" + encontro.getIdEncontro() + "] - Nome: {" + encontro.getNome() + "} - Localização: (" + encontro.getLocalizacao().getX() + encontro.getLocalizacao().getY() +
                    ") -  Data: (" + encontro.getData().getAno() + "/" + encontro.getData().getMes() + "/" + encontro.getData().getDia() + "," + encontro.getData().getHora() + ":" + encontro.getData().getMinuto()
                    + ")\n Profissionais participantes do encontro:");
            for (int v = 0; v < g.V(); v++) {
                if (search.marked(v)) {
                    StdOut.println("\tid: " + bd.getProfissionais().get(v).getIdProfissional() + "\tNome: "
                            + bd.getProfissionais().get(v).getPrimeiroNome() + " " + bd.getProfissionais().get(v).getUltimoNome() + "\tLocalização: "
                            + bd.getProfissionais().get(v).getLocalizacao().getX() + bd.getProfissionais().get(v).getLocalizacao().getY() + " ");

                }
            }
            StdOut.println();
        }

    }




    public void listarProfissionaisParticipantesThisEncontroInThisInterval(BD bd, Encontro encontro, Data tempoinicial, Data tempofinal) {
        System.out.println("Os profissionais participantes do encontro -" + encontro + "\n no intervalo de tempo de " + tempoinicial + " até " + tempofinal + " são:");
        for (Integer i: bd.getProfissionais().keys()){


            if( bd.getEncontros().get(encontro.getIdEncontro()).getHoraChegadaProfissional().contains(i) ){
                if(encontro.getHoraChegadaProfissional().get(i).beforeDate(tempofinal) && encontro.getHoraChegadaProfissional().get(i).afterDate(tempoinicial)){

                    System.out.println(bd.getProfissionais().get(i).toString());
                }
            }
        }
    }

    public ArrayList<Profissional> procurarElistarProfissionaisThisCompetenciaSemEmpresaAssociada(BD bd, String tipo, int experiencia, Digraph g) {

        ArrayList<Profissional> profissionalArrayList = new ArrayList<>();
        for (Integer i : bd.getCompetencias().keys()) {
            if (bd.getCompetencias().get(i).getTipo().equals(tipo) && bd.getCompetencias().get(i).getExperiencia() == experiencia) {
                int s = bd.getCompetencias().get(i).getIdCompetencia();
                DirectedDFS search = new DirectedDFS(g, s);
                for (int v = 0; v < g.V(); v++) {
                    if (search.marked(v) && bd.getProfissionais().get(v).getEmpresaAtual() == null) {
                        // Profssional sem empresa
                        profissionalArrayList.add(bd.getProfissionais().get(v));
                    }
                }
            }
        }
        return profissionalArrayList;
    }


    /***
     *
     * @param bd base de dados
     * @param g grafo ligacaoEmpresaProfissional para pesquisa dos profissionais que nao trabalham na empresa
     * @param e empresa que é pesquisada e a qual sao sugeridos os profissionais
     */
    public ArrayList<Profissional> sugerirProfissionaisToEmpresasBasedInCompetencias(BD bd, Digraph g, Empresa e) { //ordenado por experiencia profissional

        ArrayList<Profissional> auxidprofissionais = new ArrayList<>();
        ArrayList<Integer> auxexperiencia = new ArrayList<>(); // array contem o inteiro da experiencias na mesma ordem que o array dos ids e correspondente ao profissional

        int s = e.getIdEmpresa(); //id empresa a procurar no grafo de empresas profissionais
        DirectedDFS search = new DirectedDFS(g, s); // pesquisa com dfs


        for (int v = 0; v < g.V(); v++) {
            if (!search.marked(v) || bd.getProfissionais().get(v).getEmpresaAtual().getIdEmpresa() == s) {// entra no else se os profissionais iterados no for nso forem
                // correspondentes a empresa procurada , ou seja nao sao trabalhadores da empresa (nao vou sugerir a empresa profissionais que ja la trabalham)
                for (Integer w : bd.getCompetencias().keys()) { // itera todas as competencias
                    if (bd.getProfissionais().contains(v) && bd.getProfissionais().get(v).getCompetencias().contains(w)) {

                        auxidprofissionais.add(bd.getProfissionais().get(v)); // adiciona os profissionais possiveis sugeridos à empresa no array
                        auxexperiencia.add(bd.getProfissionais().get(v).getCompetencias().get(w).getExperiencia()); // adiciona a respetiva experiencia em outro array

                    }
                }
            }
        }

        for (int i = 0; i < auxexperiencia.size(); i++) { // itera o array das experiencias
            for (int j = i + 1; j < auxexperiencia.size(); j++) { // itera o mesmo para comparar as experiencias e ordena las da maior para a menor
                if (auxexperiencia.get(i) < auxexperiencia.get(j)) {
                    int aux = auxexperiencia.get(i);
                    auxexperiencia.set(i, auxexperiencia.get(j));
                    auxexperiencia.set(j, aux);

                    //ordena o array de profissionais consequentemente
                    Profissional aux2 = auxidprofissionais.get(i);
                    auxidprofissionais.set(i, auxidprofissionais.get(j));
                    auxidprofissionais.set(j, aux2);

                }
            }
        }
        return auxidprofissionais;
    }


    public ArrayList<Integer> sugerirProfissionalRelacionarWithThisEmpresaBasedInThisProfissional(BD bd, Profissional profissional, EdgeWeightedGraph grafoprofissionais, Digraph profissionaisEmpresasQueSegue, Digraph EmpresasSeguidasPorProfissionais) {
        double compatiblidade = 0;
        int idProfissionalSugerido = 0;
        int s = profissional.getIdProfissional();
        ArrayList<Integer> idsdeProfissionaisQueSegueEmpresas = new ArrayList<>();
        ArrayList<Integer> returnIdProfissionalIdEmpresa = new ArrayList<>();


        BreadthFirstDirectedPaths bfs = new BreadthFirstDirectedPaths(profissionaisEmpresasQueSegue, s); // procura as empresas que o profissional segue
        for (int v = 0; v < profissionaisEmpresasQueSegue.V(); v++) {
            if (bfs.hasPathTo(v) && bfs.distTo(v) == 1) { // v = empresa retornada

                BreadthFirstDirectedPaths bfs1 = new BreadthFirstDirectedPaths(EmpresasSeguidasPorProfissionais, v); //  procura no grafo pela empresa retornada- v , que o profissional inicial segue
                for (int j = 0; j < EmpresasSeguidasPorProfissionais.V(); j++) {// percorrer os profissionais que a empresa segue
                    if (bfs1.hasPathTo(j) && bfs1.distTo(j) == 1) {
                        idsdeProfissionaisQueSegueEmpresas.add(j);
                    }
                }
                DijkstraUndirectedSP sp = new DijkstraUndirectedSP(grafoprofissionais, s); // procura no garfo profissionais a maior conexao com outro profissional

                for (int t = 0; t < grafoprofissionais.V(); t++) {
                    if (sp.hasPathTo(t)) { // t = profissional
                        for (Edge e : sp.pathTo(t)) {

                            if (e.weight() >= compatiblidade) { // encontra qual o profissional com maior compatiblidade
                                compatiblidade = e.weight();
                                idProfissionalSugerido = bd.getProfissionais().get(t).getIdProfissional(); // guarda o id do profissional com maior compatiblidade
                            }
                        }
                    }
                }
                if (!idsdeProfissionaisQueSegueEmpresas.contains(idProfissionalSugerido)) {
                    returnIdProfissionalIdEmpresa.add(v);
                    returnIdProfissionalIdEmpresa.add(idProfissionalSugerido);

                    return returnIdProfissionalIdEmpresa;
                }
            }
        }
        //}7
        return null;
    }


    public ArrayList<Profissional> searchProfissionaisMultiplosCriterios(Graphs graphs, BD bd, String tipoDeExperiencia, boolean empregado, Digraph g, int minimoExperienciaProfissional) {
        ArrayList<Profissional> profissionaisMultiplosCriterios = new ArrayList<>();
        for (Integer i : bd.getCompetencias().keys()) {
            if (bd.getCompetencias().get(i).getTipo().equals(tipoDeExperiencia) && bd.getCompetencias().get(i).getExperiencia() >= minimoExperienciaProfissional) {
                BreadthFirstDirectedPaths bfs = new BreadthFirstDirectedPaths(g, i);

                for (int v = 0; v < g.V(); v++) {
                    if (bfs.hasPathTo(v) && bfs.distTo(v) == 1) {
                        // sem empresa atual
                        if (!empregado && bd.getProfissionais().get(v).getEmpresaAtual() == null) {
                            profissionaisMultiplosCriterios.add(bd.getProfissionais().get(v));
                        }
                        // com empresa atual
                        if (empregado && bd.getProfissionais().get(v).getEmpresaAtual() != null) {
                            profissionaisMultiplosCriterios.add(bd.getProfissionais().get(v));
                        }
                    }
                }
            }
        }


        return profissionaisMultiplosCriterios;

    }

    public void pathOfThisProfissionalToThisEmpresa(BD bd, Profissional profissional, Empresa empresa, EdgeWeightedDigraph g, Graphs graphs) {
        int sourcePontoPPartidaDoProfissional = 0;
        int sourceDestinationEmpresa = 0;
        Point pointProfissional = profissional.getLocalizacao();
        for (Integer b : bd.getStFinal().keys()) {
            if (bd.getStFinal().get(b).getObj() == empresa) {
                sourceDestinationEmpresa = b;
            }

        }

        //percorrer stfinal e retirar pontos o ponto mais proximo
        // definir ponto como source e procurar caminho
        double distanciamenor = 1000.00;
        for (Integer a : bd.getStFinal().keys()) {
            if (bd.getStFinal().get(a).getObj() instanceof PontosP) {
                Point pointDografo = bd.getStFinal().get(a).getLocalizacao();
                if (distanceFromPoints(pointDografo, pointProfissional) < distanciamenor) {
                    distanciamenor = distanceFromPoints(pointDografo, pointProfissional);
                    sourcePontoPPartidaDoProfissional = a; // encontra local , sendo um ponto de passagem, onde o

                }
            }
        }
        DijkstraSPProject sp = new DijkstraSPProject(g, sourcePontoPPartidaDoProfissional, "distance", graphs);//can be costcar , costbike, costfoot, distance OR null


        // print shortest path

        if (sp.hasPathTo(sourceDestinationEmpresa)) {
            StdOut.println("\n\nO Profissional " + profissional + "\ndevera dirigir se ao ponto de partida:\n" + bd.getStFinal().get(sourcePontoPPartidaDoProfissional) + "\n que se encontra à distancia de " + distanciamenor + " km de si, para se deslocar à empresa:\n" + bd.getStFinal().get(sourceDestinationEmpresa).getObj());
            StdOut.println("\n Total: (" + sp.distTo(sourceDestinationEmpresa) + " km) + " + distanciamenor);
            for (DirectedEdge e : sp.pathTo(sourceDestinationEmpresa)) {
                StdOut.println(bd.getStFinal().get(e.from()).getObj() + " ->  " + intValue(graphs.getWeights().get(e.weight()).getDistancia()) + " km  -> " + bd.getStFinal().get(e.to()).getObj());
            }
            StdOut.println();
        } else {
            StdOut.printf("%d to %d         no path\n", sourcePontoPPartidaDoProfissional, sourceDestinationEmpresa);
        }

    }

    /**
     * @param pp      - ponto de partida
     * @param empresa se escolhido empresa como destino , enc devera ser null
     * @param enc     se escolhido encontro como destino, empresa debera ser null
     * @param bd      - base de dados
     * @param g       . grafo caminhos a ser pesquisado
     * @param graphs  - classe graphs
     */
    //menor distncia entre nos path mais curto
    public void shortestPathBetweenPontoPEmpresaOrEncontroBasedInDistancia(PontosP pp, Empresa empresa, Encontro enc, BD bd, EdgeWeightedDigraph g, Graphs graphs) {
        if (enc != null) { // se o destino for um encontro
            int source = 0;
            int sourceFinal = 0;
            for (Integer i : bd.getStFinal().keys()) {
                if (bd.getStFinal().get(i).getObj() == enc) {
                    sourceFinal = i;
                }
                if (bd.getStFinal().get(i).getObj() == pp) {
                    source = i;
                }
            }
            //escolhido enc
            DijkstraSPProject sp = new DijkstraSPProject(g, source, "distance", graphs);//can be costcar , costbike, costfoot, distance OR null
            if (sp.hasPathTo(sourceFinal)) {
                StdOut.println("\n\nO caminho mais curto do ponto de passagem " + pp + "\nao encontro :\n" + enc + "com base na distancia é:");
                StdOut.println("\n Total: (" + sp.distTo(sourceFinal) + " km)");
                for (DirectedEdge e : sp.pathTo(sourceFinal)) {
                    StdOut.println(bd.getStFinal().get(e.from()).getObj() + " ->  " + intValue(graphs.getWeights().get(e.weight()).getDistancia()) + " km -> " + bd.getStFinal().get(e.to()).getObj());
                }
                StdOut.println();
            } else {
                StdOut.printf("%d to %d         no path\n", source, sourceFinal);
            }
        }
        if (empresa != null) {
            // escolhido empresa
            int source = 0;
            int sourceFinal = 0;
            for (Integer i : bd.getStFinal().keys()) {
                if (bd.getStFinal().get(i).getObj() == empresa) {
                    sourceFinal = i;
                }
                if (bd.getStFinal().get(i).getObj() == pp) {
                    source = i;
                }
            }
            //escolhido enc
            DijkstraSPProject sp = new DijkstraSPProject(g, source, "distance", graphs);//can be costcar , costbike, costfoot, distance OR null
            if (sp.hasPathTo(sourceFinal)) {
                StdOut.println("\n\nO caminho mais curto do ponto de passagem " + pp + "\nà empresa :\n" + empresa + "com base na distancia é:");
                StdOut.println("\n Total: (" + sp.distTo(sourceFinal) + " km)");
                for (DirectedEdge e : sp.pathTo(sourceFinal)) {
                    StdOut.println(bd.getStFinal().get(e.from()).getObj() + " ->  " + intValue(graphs.getWeights().get(e.weight()).getDistancia()) + " km  -> " + bd.getStFinal().get(e.to()).getObj());

                }
                StdOut.println();
            } else {
                StdOut.printf("%d to %d         no path\n", source, sourceFinal);
            }
        }
    }


//ordenado pelo menor custo temporal

    /**
     * @param pp            - ponto de partida
     * @param empresa       se escolhido empresa como destino , enc devera ser null
     * @param enc           se escolhido encontro como destino, empresa debera ser null
     * @param bd            - base de dados
     * @param g             . grafo caminhos a ser pesquisado
     * @param graphs        - classe graphs
     * @param tipoDeVeiculo - "carro", "bicicleta" ou "pe", sem acento
     */
    public void fastestPathBetweenPontoPEmpresaOrEncontroBasedInEdgeCustoTemporal(PontosP pp, Empresa empresa, Encontro enc, BD bd, EdgeWeightedDigraph g, Graphs graphs, String tipoDeVeiculo) {
        String tipo = null;
        if (enc != null) { // se o destino for um encontro
            // escolhido empresa
            int source = 0;
            int sourceFinal = 0;
            for (Integer i : bd.getStFinal().keys()) {
                if (bd.getStFinal().get(i).getObj() == enc) {
                    sourceFinal = i;
                }
                if (bd.getStFinal().get(i).getObj() == pp) {
                    source = i;
                }
            }
            //escolhido enc
            if (tipoDeVeiculo.equals("carro")) {
                tipo = "costcar";
            }
            if (tipoDeVeiculo.equals("bicicleta")) {
                tipo = "costbike";
            }
            if (tipoDeVeiculo.equals("pe")) {
                tipo = "costfoot";
            }

            DijkstraSPProject sp = new DijkstraSPProject(g, source, tipo, graphs);//can be costcar , costbike, costfoot, distance OR null


            if (sp.hasPathTo(sourceFinal)) {
                StdOut.println("\n\nO caminho mais curto do ponto de passagem " + pp + "deslocando-se de " + tipoDeVeiculo + "\nao encontro :\n" + enc + " com base na distancia é::");
                StdOut.println("\n Total: (" + sp.distTo(sourceFinal) + " min)");
                for (DirectedEdge e : sp.pathTo(sourceFinal)) {
                    if (tipoDeVeiculo.equals("carro")) {
                        StdOut.println(bd.getStFinal().get(e.from()).getObj() + " ->  " + intValue(graphs.getWeights().get(e.weight()).getCustoTemporaldeCarro()) + " min  -> " + bd.getStFinal().get(e.to()).getObj());
                    }
                    if (tipoDeVeiculo.equals("bicicleta")) {
                        StdOut.println(bd.getStFinal().get(e.from()).getObj() + " ->  " + intValue(graphs.getWeights().get(e.weight()).getCustoTemporaldebicicleta()) + " min  -> " + bd.getStFinal().get(e.to()).getObj());
                    }
                    if (tipoDeVeiculo.equals("pe")) {
                        StdOut.println(bd.getStFinal().get(e.from()).getObj() + " ->  " + intValue(graphs.getWeights().get(e.weight()).getCustoTemporalaPe()) + " min  -> " + bd.getStFinal().get(e.to()).getObj());
                    }
                }
                StdOut.println();
            } else {
                StdOut.printf("%d to %d         no path\n", source, sourceFinal);
            }
        }
        if (empresa != null) {
            // escolhido empresa
            int source = 0;
            int sourceFinal = 0;
            for (Integer i : bd.getStFinal().keys()) {
                if (bd.getStFinal().get(i).getObj() == empresa) {
                    sourceFinal = i;
                }
                if (bd.getStFinal().get(i).getObj() == pp) {
                    source = i;
                }
            }
            //escolhido enc
            if (tipoDeVeiculo.equals("carro")) {
                tipo = "costcar";
            }
            if (tipoDeVeiculo.equals("bicicleta")) {
                tipo = "costbike";
            }
            if (tipoDeVeiculo.equals("pe")) {
                tipo = "costfoot";
            }

            DijkstraSPProject sp = new DijkstraSPProject(g, source, tipo, graphs);//can be costcar , costbike, costfoot, distance OR null


            if (sp.hasPathTo(sourceFinal)) {
                StdOut.println("\n\nO caminho mais curto do ponto de passagem " + pp + "deslocando-se de " + tipoDeVeiculo + "\nà empresa :\n" + empresa + " com base na distancia é::");
                StdOut.println("\n Total: (" + sp.distTo(sourceFinal) + " min)");
                for (DirectedEdge e : sp.pathTo(sourceFinal)) {
                    if (tipoDeVeiculo.equals("carro")) {
                        StdOut.println(bd.getStFinal().get(e.from()).getObj() + " ->  " + intValue(graphs.getWeights().get(e.weight()).getCustoTemporaldeCarro()) + " min  -> " + bd.getStFinal().get(e.to()).getObj());
                    }
                    if (tipoDeVeiculo.equals("bicicleta")) {
                        StdOut.println(bd.getStFinal().get(e.from()).getObj() + " ->  " + intValue(graphs.getWeights().get(e.weight()).getCustoTemporaldebicicleta()) + " min  -> " + bd.getStFinal().get(e.to()).getObj());
                    }
                    if (tipoDeVeiculo.equals("pe")) {
                        StdOut.println(bd.getStFinal().get(e.from()).getObj() + " ->  " + intValue(graphs.getWeights().get(e.weight()).getCustoTemporalaPe()) + " min  -> " + bd.getStFinal().get(e.to()).getObj());
                    }
                }
                StdOut.println();
            } else {
                StdOut.printf("%d to %d         no path\n", source, sourceFinal);
            }
        }
    }


    /**
     * @param pp      - ponto de partida
     * @param empresa se escolhido empresa como destino , enc devera ser null
     * @param enc     se escolhido encontro como destino, empresa debera ser null
     * @param bd      - base de dados
     * @param g       . grafo caminhos a ser pesquisado
     * @param graphs  - classe graphs
     */
    public void shortestePathBetweenPontoPEmpresaOrEncontroBasedInNSaltos(PontosP pp, Empresa empresa, Encontro enc, BD bd, EdgeWeightedDigraph g, Graphs graphs) {
        if (enc != null) { // se o destino for um encontro
            int source = 0;
            int sourceFinal = 0;
            for (Integer i : bd.getStFinal().keys()) {
                if (bd.getStFinal().get(i).getObj() == enc) {
                    sourceFinal = i;
                }
                if (bd.getStFinal().get(i).getObj() == pp) {
                    source = i;
                }
            }
            //escolhido enc
            DijkstraSPProject sp = new DijkstraSPProject(g, source, "jumps", graphs);//can be costcar , costbike, costfoot, distance OR jumps
            if (sp.hasPathTo(sourceFinal)) {
                StdOut.println("\n\nO caminho mais curto do ponto de passagem " + pp + "\nao encontro :\n" + enc + "\ncom base no numero de saltos:");
                StdOut.println("\n Total: (" + intValue(sp.distTo(sourceFinal)) + " saltos)");
                for (DirectedEdge e : sp.pathTo(sourceFinal)) {
                    StdOut.println(bd.getStFinal().get(e.from()).getObj() + " ->  " + bd.getStFinal().get(e.to()).getObj());
                }
                StdOut.println();
            } else {
                StdOut.printf("%d to %d         no path\n", source, sourceFinal);
            }
        }
        if (empresa != null) {
            // escolhido empresa
            int source = 0;
            int sourceFinal = 0;
            for (Integer i : bd.getStFinal().keys()) {
                if (bd.getStFinal().get(i).getObj() == empresa) {
                    sourceFinal = i;
                }
                if (bd.getStFinal().get(i).getObj() == pp) {
                    source = i;
                }
            }
            //escolhido enc
            DijkstraSPProject sp = new DijkstraSPProject(g, source, "jumps", graphs);//can be costcar , costbike, costfoot, distance OR jumps
            if (sp.hasPathTo(sourceFinal)) {
                StdOut.println("\n\nO caminho mais curto do ponto de passagem " + pp + "\nà empresa :\n" + empresa + "com base no numero de saltos:");
                StdOut.println("\n Total: (" + sp.distTo(sourceFinal) + " saltos)");
                for (DirectedEdge e : sp.pathTo(sourceFinal)) {
                    StdOut.println(bd.getStFinal().get(e.from()).getObj() + " ->  " + bd.getStFinal().get(e.to()).getObj());
                }
                StdOut.println();
            } else {
                StdOut.printf("%d to %d         no path\n", source, sourceFinal);
            }
        }
    }

}
