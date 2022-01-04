package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaUpdateForm {

  @NotNull(message = "Preencha o campo corretamente!")
  @Positive(message = "Peso precisa ser positivo")
  private double peso;

  @NotNull(message = "Preencha o campo corretamente!")
  @Positive(message = "Altura precisa ser positivo")
  private double altura;
}
